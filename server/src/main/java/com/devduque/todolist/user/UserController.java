package com.devduque.todolist.user;
// Protocolos HTTP's

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// Controlar como API Restful
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

// Babá do objeto (Administra tudo)
import org.springframework.beans.factory.annotation.Autowired;

// Entidade de Resposta
import org.springframework.http.ResponseEntity;

// Controlador com estrutura de API Restful
@RestController

// Mapeamento de rotas
@RequestMapping("/users")
public class UserController {

    // Spring gerenciando para administrar (Fazendo instâncias quando necessário)
    @Autowired
    private IUserRepository userRepository;

    // Declarando que o mapeamento é do tipo Post
    @PostMapping("/")

    // Pegando do corpo da requisição com dados da classe UserModel
    // ResponseEntity é um objeto para criar diferentes respostas
    public ResponseEntity createUser(@RequestBody UserModel userModel) {
        
        var user = this.userRepository.findByUsername(userModel.getUsername());
        
        // Se o username for encontrado na tabela.
        if(user != null) {
            return ResponseEntity.status(400).body("Usuário já cadastrado! ");
        }

        var passwordHashred = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword().toCharArray());
        
        userModel.setPassword(passwordHashred);

        // Salvando os atributos para a tabela com atributos de UserModel
        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(201).body(userCreated);
    }    
}
