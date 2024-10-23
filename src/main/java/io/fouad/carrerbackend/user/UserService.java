package io.fouad.carrerbackend.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        User user = UserMapper.INSTANCE.UserCreateDTOToUser(userCreateDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserMapper.INSTANCE.UserToUserResponseDTO(user);
    }
    public List<UserResponseDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(UserMapper.INSTANCE::UserToUserResponseDTO)
                .toList();
    }

    public UserResponseDTO findUserById(Integer id) {
        return userRepository
                .findById(id)
                .stream()
                .map(UserMapper.INSTANCE::UserToUserResponseDTO)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("user not found with id : "+id));
    }

    public UserResponseDTO findUserByEmail(String email) {
        return userRepository
                .findUserByEmail(email)
                .stream()
                .map(UserMapper.INSTANCE::UserToUserResponseDTO)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("user not found with email :"+email));
    }

    public ResponseEntity<Void> deleteUserByID(Integer id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("user not found with id : "+id));
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

}
