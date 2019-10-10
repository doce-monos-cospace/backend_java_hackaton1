package org.docemonos.hackaton1.backend1.model;

import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("task")
@Data
public class Task {

    @Id
    private String id;
    private String nombre;
    private LocalDateTime tiempo_ini;
    private LocalDateTime tiempo_fin;
    private Boolean esPausada;
    private Long acumulada = 0L;
    private Boolean esCerrada;


}
