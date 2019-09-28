package org.docemonos.hackaton1.backend1;

import org.docemonos.hackaton1.backend1.dao.TareasRepository;
import org.docemonos.hackaton1.backend1.model.Tareas;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Backend1ApplicationTests {

    @Autowired
    TareasRepository tareasRepository;

    @Test
    public void pruebaTareas() {
        Date date = new Date();
        long longDate = date.getTime();

        Tareas tareas = new Tareas();
        tareas.setNombre("Tarea-back-spring");
        tareas.setTiempo_ini(new Timestamp(longDate));
        tareas.setEsPausada(false);
        tareas.setAcumulada(0L);
        tareas.setEsCerrada(false);

        tareas = tareasRepository.save(tareas);

        System.out.print(tareas);
        Assert.assertTrue(tareas.getId().length()>0);

    }

}
