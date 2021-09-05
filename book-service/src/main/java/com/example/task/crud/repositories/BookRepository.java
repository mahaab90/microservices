package com.example.task.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.task.crud.model.Book;



@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
