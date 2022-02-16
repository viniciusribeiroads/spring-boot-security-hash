package com.login.filmes.service;

import com.login.filmes.model.Filme;
import com.login.filmes.repository.FilmeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FilmeService {

    public FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    public Page<Filme> listAll(Pageable paginacao){
        return (Page<Filme>) filmeRepository.findAll(paginacao);
    }

    public ResponseEntity<Filme>save(Filme filme){
        return ResponseEntity.ok(filmeRepository.save(filme));
    }



}
