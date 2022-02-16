package com.login.filmes.service;

import com.login.filmes.Security.SecurityAccess;
import com.login.filmes.model.Login;
import com.login.filmes.repository.LoginRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public final LoginRepository loginRepository;
    private final PasswordEncoder encoder;

    public LoginService(LoginRepository loginRepository, PasswordEncoder encoder){
        this.loginRepository = loginRepository;
        this.encoder = encoder;
    }

    public Page<Login> listAll(Pageable paginacao){
        return (Page<Login>) loginRepository.findAll(paginacao);
    }

    public ResponseEntity<Login>save(Login login){
        login.setPassword(encoder.encode(login.getPassword()));
        return ResponseEntity.ok(loginRepository.save(login));
    }



}
