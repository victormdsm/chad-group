package com.eventflow.project.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Registrations")
public class RegistrationEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //FALTA ADICIONAR ALGUNS ATRIBUTOS VERIFICAR NA HORA Q FOR FAZER OS RELACIONAMENTOS

}
