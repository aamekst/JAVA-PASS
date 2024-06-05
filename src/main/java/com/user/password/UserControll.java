package com.user.password;

import com.user.password.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class UserControll {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity user(@RequestBody UserDto userDto) {
        User user = new User();
        user.setNome(userDto.getNome());

        // Criptografar a senha antes de salvar no banco de dados
        String senhaCriptografada = PasswordEncryption.encryptPassword(userDto.getPassword());
        user.setPassword(senhaCriptografada);

        User userCreated = userRepository.save(user);
        return ResponseEntity.ok().body(userCreated);
    }
}
