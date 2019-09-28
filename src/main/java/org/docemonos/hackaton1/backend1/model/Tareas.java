package org.docemonos.hackaton1.backend1.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Document("tareas")
@Data
public class Tareas {

    @Id
    private String id;
    private String nombre;
    private Timestamp tiempo_ini;
    private Timestamp tiempo_fin;
    private Boolean esPausada;
    private Long acumulada = 0L;
    private Boolean esCerrada;


}
