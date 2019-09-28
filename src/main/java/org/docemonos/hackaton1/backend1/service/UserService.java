package org.docemonos.hackaton1.backend1.service;

import org.docemonos.hackaton1.backend1.model.User;

import java.util.List;

public interface UserService {

    List<User> getall();
    void createUser(User userDto);
    User updateUser(String name, User userUpdate);
    void deleteUser(String name);

}
