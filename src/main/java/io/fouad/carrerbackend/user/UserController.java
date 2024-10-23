package io.fouad.carrerbackend.user;


import io.fouad.carrerbackend.user.dto.UserCreateDTO;
import io.fouad.carrerbackend.user.dto.UserResponseDTO;
import io.fouad.carrerbackend.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@ApiResponse(description = "manipuler les users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "trouver tous les users ",
            description = "return un tableau des users")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "ajouter un user",
            description = "ajouter un user avec tout ces attributs inclus: email , password ..")
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        System.out.println(userCreateDTO);
        return ResponseEntity.ok(userService.createUser(userCreateDTO));
    }

    @Operation(summary = "Trouver une user par ID",
            description = "Récupère une user à partir de son ID unique.")
    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Integer id) {;
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @Operation(summary = "Supprimer un user par ID",
            description = "Récupère un user à partir de son ID unique.")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
        return userService.deleteUserByID(id);
    }


}
