package com.eb.gerenciamentolivros.repositories;

import com.eb.gerenciamentolivros.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
}
