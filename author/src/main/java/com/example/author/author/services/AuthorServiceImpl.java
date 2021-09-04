package com.example.author.author.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.author.author.model.Author;
import com.example.author.author.repositories.AuthorRepository;
@Service

public class AuthorServiceImpl implements AuthorService{
	AuthorRepository authorrepository;
	public AuthorServiceImpl (AuthorRepository authorrepository) {
		this.authorrepository=authorrepository;
		
	}
	@Override
	public List<Author> getAuthors() {
		// TODO Auto-generated method stub
		List<Author> authors= new ArrayList<>();
		authorrepository.findAll().forEach(authors::add);
        return authors;
	}

	@Override
	public Author getAuthorById(String name) {
		// TODO Auto-generated method stub
		return authorrepository.findByName(name);
	}

	@Override
	public Author insert(Author Author) {
		// TODO Auto-generated method stub
		return authorrepository.save(Author);
	}

	@Override
	public void updateAuthor(String name, Author Author) {
		// TODO Auto-generated method stub
		Author authorFromDb = authorrepository.findByName(name);
		authorFromDb.setAdress(Author.getAdress());
		authorFromDb.setMail(Author.getMail());
		authorrepository.save(authorFromDb);
	}

	@Override
	public void deleteAuthor(String AuthorName) {
		// TODO Auto-generated method stub
		authorrepository.deleteAll();
	}

}
