package com.devduque.todolist.user;

// Criando ID único
import java.util.UUID;

// Criando data
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

// Usando persistence (Camada mais próxima do usuario)
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// Criando Getters e Setters automaticamente
import lombok.Data;

// Gera Getters e Setters para os atributos (Lombok)
@Data
// Criando a tabela de usuários com os atributos
@Entity(name="tb_users")
public class UserModel {

    // Atributos base de Usuário

    // Campo ID com JPA
    @Id
    // Gerando um ID do tipo UUID
    @GeneratedValue(generator = "UUID")
    private UUID id;

    //Regra para que username seja único
    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
