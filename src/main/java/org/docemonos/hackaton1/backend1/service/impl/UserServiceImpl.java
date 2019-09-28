package org.docemonos.hackaton1.backend1.service.impl;

import lombok.RequiredArgsConstructor;
import org.docemonos.hackaton1.backend1.dao.UserRepository;
import org.docemonos.hackaton1.backend1.model.User;
import org.docemonos.hackaton1.backend1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getall() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User userToCreate) {
        userToCreate.setPassword(userToCreate.getPassword());
        userRepository.save(userToCreate);
    }

    @Override
    public User updateUser(String name, User userUpdate) {
        User userToUpdate = userRepository.findUserByNameEquals(name);
        if (userToUpdate != null) {
            userToUpdate.setName(userUpdate.getName());
            userToUpdate.setPassword(userUpdate.getPassword());
            userToUpdate.setRole(userUpdate.getRole());
            userRepository.save(userToUpdate);
        }
        return userUpdate;
    }

    @Override
    public void deleteUser(String name)  {
        User userDeleted = userRepository.findUserByNameEquals(name);
        if (userDeleted != null)
            userRepository.delete(userDeleted);

    }


}
