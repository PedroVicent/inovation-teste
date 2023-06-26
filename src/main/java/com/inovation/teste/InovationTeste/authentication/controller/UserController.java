package com.inovation.teste.InovationTeste.authentication.controller;

import com.inovation.teste.InovationTeste.entity.Usuario;
import com.inovation.teste.InovationTeste.authentication.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository repository;


    @GetMapping
    public ResponseEntity<List<Usuario>> listAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(repository.save(usuario));
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String password) {
        Optional<Usuario> optionalUsuario = repository.findByLogin(login);
        if (!optionalUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = false;
        valid = encoder.matches(password, optionalUsuario.get().getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
