package com.eb.gerenciamentolivros.controllers;

import com.eb.gerenciamentolivros.models.BookModel;

import com.eb.gerenciamentolivros.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping
    public ResponseEntity<List<BookModel>> findAll(){
        List<BookModel> listaLivros = bookServices.listarTodos();
        return ResponseEntity.ok(listaLivros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> findById(@PathVariable Long id){
        Optional<BookModel> bookModel = bookServices.findById(id);
        if(bookModel.isPresent()) {
            return ResponseEntity.ok(bookModel.get());
        } else  {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BookModel> save(@RequestBody BookModel bookModel){
        BookModel bookCriado = bookServices.criarLivro(bookModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(bookCriado);
    }
}
