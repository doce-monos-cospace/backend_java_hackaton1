package org.docemonos.hackaton1.backend1.controller;

import org.docemonos.hackaton1.backend1.dto.UserDto;
import org.docemonos.hackaton1.backend1.mapper.UserMapper;
import org.docemonos.hackaton1.backend1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private  UserService userService;
    @Autowired
    private  UserMapper userMapper;

    @GetMapping("/")
    public List<UserDto> getAll() {
        return userMapper.userListToUserDTOList(userService.getall());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto userDto) {
        userService.createUser(userMapper.userDTOToUser(userDto));
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable("username") String userName) {
        userService.deleteUser(userName);
    }

    @PutMapping("/{username}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDto updateUser(@PathVariable("username") String userName, @RequestBody UserDto userDto) {
        return userMapper.userToUserDTO(userService.updateUser(userName,userMapper.userDTOToUser(userDto)));
    }
}
