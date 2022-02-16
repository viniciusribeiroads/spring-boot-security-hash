package com.login.filmes.controller;

import com.login.filmes.model.Filme;
import com.login.filmes.model.Login;
import com.login.filmes.service.FilmeService;
import com.login.filmes.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    public LoginService loginService;

    @GetMapping("/all")
    public Page<Login> listAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return loginService.listAll(paginacao);
    }

    @PostMapping("/new")
    public ResponseEntity<Login>inserNew(@RequestBody Login login){
        if (login == null){
            return ResponseEntity.badRequest().build();
        }
        return loginService.save(login);
    }
}
