package com.example.author.author.services;

import java.util.List;

import com.example.author.author.model.Author;



public interface AuthorService {
List<Author> getAuthors();
	
	Author getAuthorById(String name);

	Author insert(Author Author);

    void updateAuthor(String name, Author Author);

    void deleteAuthor(String AuthorName);
}
