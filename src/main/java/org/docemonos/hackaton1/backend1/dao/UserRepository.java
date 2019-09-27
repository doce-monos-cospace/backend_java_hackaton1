package org.docemonos.hackaton1.backend1.dao;

import org.docemonos.hackaton1.backend1.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByNameEquals(String username);
}
