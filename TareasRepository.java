package org.docemonos.hackaton1.backend1.dao;

import java.util.List;

import org.docemonos.hackaton1.backend1.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareasRepository  extends MongoRepository<Task, String>{

	List<Task> findAllByEsPausadaFalseAndEsCerradaFalseOrderById();

	List<Task> findAllByEsCerradaTrueOrderById();

}
