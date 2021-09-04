package com.example.author.author.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.author.author.model.Author;


@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

	Author findByName(String nameString);

}
