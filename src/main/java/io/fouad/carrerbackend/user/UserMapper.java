package io.fouad.carrerbackend.user;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO UserToUserResponseDTO(User user);
    User UserCreateDTOToUser(UserCreateDTO userCreateDTO);
    UserCreateDTO userToUserCreateDTO(User user);
}
