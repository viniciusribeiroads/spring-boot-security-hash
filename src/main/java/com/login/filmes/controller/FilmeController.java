package com.login.filmes.controller;

import com.login.filmes.model.Filme;
import com.login.filmes.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class FilmeController {

    @Autowired
    public FilmeService filmeService;

    @GetMapping("/all")
    public Page<Filme> listAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){
        return filmeService.listAll(paginacao);
    }

    @PostMapping("/new")
    public ResponseEntity<Filme>inserNew(@RequestBody Filme filme){
        if (filme == null){
            return ResponseEntity.badRequest().build();
        }
        return filmeService.save(filme);
    }
}
