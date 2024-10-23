package io.fouad.carrerbackend.auth;


import io.fouad.carrerbackend.jwt.JWTUtil;
import io.fouad.carrerbackend.user.dto.UserCreateDTO;
import io.fouad.carrerbackend.user.dto.UserMapper;
import io.fouad.carrerbackend.user.dto.UserResponseDTO;
import io.fouad.carrerbackend.user.model.User;
import io.fouad.carrerbackend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final UserService userService;

    public ResponseEntity<?> login(AuthenticationRequest request) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.username(),
                            request.password()
                    )
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        User user = (User) authentication.getPrincipal();
        UserCreateDTO userCreateDTO = UserMapper.INSTANCE.userToUserCreateDTO(user);
        String token = jwtUtil.issueToken(userCreateDTO.username(), userCreateDTO.roles());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(token);
        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .body(authenticationResponse);
    }

    public ResponseEntity<?> register(UserCreateDTO userCreateDTO) {
        UserResponseDTO user = userService.createUser(userCreateDTO);
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(userCreateDTO.email(),userCreateDTO.password());
        return login(authenticationRequest);
    }
}
