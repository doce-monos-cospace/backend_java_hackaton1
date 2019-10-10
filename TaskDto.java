package org.docemonos.hackaton1.backend1.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
	
    private String id;
    private String nombre;
    private Date tiempo_ini;
    private Date tiempo_fin;
    private Boolean esPausada;
    private Long acumulada = 0L;
    private Boolean esCerrada;

}
