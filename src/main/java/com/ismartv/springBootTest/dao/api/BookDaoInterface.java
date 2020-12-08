package com.ismartv.springBootTest.dao.api;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ismartv.springBootTest.entity.Book;

public interface BookDaoInterface extends JpaRepository<Book, Long>{

	List<Book> findByReader(String reader);
}
