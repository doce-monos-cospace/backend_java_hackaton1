package org.docemonos.hackaton1.backend1.service;

import org.docemonos.hackaton1.backend1.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {

    List<User> getall();
    void createUser(User userDto);
    User updateUser(String name, User userUpdate) throws UsernameNotFoundException;
    void deleteUser(String name) throws UsernameNotFoundException;

}
