package com.inovation.teste.InovationTeste.authentication.service;

import com.inovation.teste.InovationTeste.authentication.data.DetalheUsuarioData;
import com.inovation.teste.InovationTeste.authentication.repository.UsuarioRepository;
import com.inovation.teste.InovationTeste.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByLogin(username);
        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Usuario [" + username + "] não encontrado");
        }
        return new DetalheUsuarioData(usuario);
    }
}
