package com.devduque.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devduque.todolist.utils.Utils;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;
    
    @PostMapping("/")
    public ResponseEntity createTask(@RequestBody TaskModel taskModel, HttpServletRequest request) {

        var idUser = request.getAttribute("idUser");

        taskModel.setIdUser((UUID) idUser);

        var currentDate = LocalDateTime.now();

        // Comparando com data atual
        if(currentDate.isAfter(taskModel.getStartAt()) ||currentDate.isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(400).body("Data de inicio / Data de termino deve ser maior que a data atual");
        }

        // Comparando a data de inicio com a de termino
        if(taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(400).body("Data de inicio deve ser menor que a data de termino");
        }
        
        var task = this.taskRepository.save(taskModel);

        return ResponseEntity.status(200).body(task);
    }

    @GetMapping("/")
    public List<TaskModel> listTask(HttpServletRequest request) {
        var idUser = request.getAttribute("idUser");
        var tasks = this.taskRepository.findByIdUser((UUID) idUser);
    
        return tasks;
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTask(@RequestBody TaskModel taskModel, @PathVariable UUID id,  HttpServletRequest request) {

        // Pegando tarefa pelo ID
        var task = this.taskRepository.findById(id).orElse(null);

        // Conferindo tarefa foi encontrada
        if(task == null) {
            return ResponseEntity.status(400).body("Tarefa não encontrada!");
        }

        // Pegando usuário pelo ID
        var idUser = request.getAttribute("idUser");

        // Conferindo se a tarefa é do usuário para editar
        if(!task.getIdUser().equals(idUser)) {
            return ResponseEntity.status(400).body("Usuário não tem permissão para alterar essa tarefa!");
        }

        // Atualizando dados sem deixar NULL
        Utils.copyNonNullProperties(taskModel, task);

        var taskUpdated = this.taskRepository.save(task);

        return ResponseEntity.ok().body(taskUpdated);
    }
}
