package com.devduque.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    // Criando campo de ID
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    // Criando título com tamanho <= 50
    @Column(length = 50)
    private String title;
    private String description;

    private LocalDateTime startAt;
    private LocalDateTime endAt; 

    private String priority;
    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Criando erro para título > 50
    public void setTitle(String title) throws Exception {
        if(title.length() > 50) {
            throw new Exception("Campo de título deve ter no máximo 50 caracteres");
        }
        this.title = title;
    }
}
