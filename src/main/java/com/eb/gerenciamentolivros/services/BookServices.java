package com.eb.gerenciamentolivros.services;

import com.eb.gerenciamentolivros.models.BookModel;
import com.eb.gerenciamentolivros.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepository bookRepository;

    public List<BookModel> listarTodos() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> findById(Long id){
        return bookRepository.findById(id);
    }

    public BookModel criarLivro(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public void deletarPorId(Long id){
        bookRepository.deleteById(id);
    }
}
