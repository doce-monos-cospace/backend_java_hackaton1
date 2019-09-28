package org.docemonos.hackaton1.backend1.dao;

import org.docemonos.hackaton1.backend1.model.Tareas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository  extends MongoRepository<Tareas, String>{

}
