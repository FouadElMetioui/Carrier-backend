package io.fouad.carrerbackend.auth;

import io.fouad.carrerbackend.user.UserCreateDTO;
import io.fouad.carrerbackend.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        return authenticationService.login(request);

    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody UserCreateDTO userCreateDTO) {
        return authenticationService.register(userCreateDTO);

    }

}
