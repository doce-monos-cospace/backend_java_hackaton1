package org.docemonos.hackaton1.backend1.mapper;

import org.docemonos.hackaton1.backend1.dto.UserDto;
import org.docemonos.hackaton1.backend1.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDto> userListToUserDTOList(List<User> userList);
    UserDto userToUserDTO(User user);

    List<User> userDTOListToUserList(List<UserDto> userDTOList);
    User userDTOToUser(UserDto userDto);


}