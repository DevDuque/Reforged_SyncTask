package com.devduque.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

//Criação de uma interface com funções do JPA, pegando o modelo (Classe de UserModel) e o tipo de id (UUID).
public interface IUserRepository extends JpaRepository<UserModel, UUID> {

    // Encontrar usuário pelo username
    UserModel findByUsername(String username);
}
