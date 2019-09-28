package org.docemonos.hackaton1.backend1.model;

import lombok.Data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("tareas")
@Data
public class Tareas {

    @Id
    private String id;
    private String nombre;
    private Date tiempo_ini;
    private Date tiempo_fin;
    private Boolean esPausada;
    private Long acumulada = 0L;
    private Boolean esCerrada;


}
