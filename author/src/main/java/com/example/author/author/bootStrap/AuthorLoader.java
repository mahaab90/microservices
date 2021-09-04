package com.example.author.author.bootStrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.author.author.model.Author;
import com.example.author.author.repositories.AuthorRepository;

@Component
public class AuthorLoader implements CommandLineRunner{
	public final AuthorRepository authorRepository;
	
	public AuthorLoader(AuthorRepository authorRepository) {
		this.authorRepository=authorRepository;
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		loadAuthors();
	}
	private void loadAuthors() {
		// TODO Auto-generated method stub
		if(authorRepository.count() == 0) {
			authorRepository.save(Author.builder()
					.adress("None")
					.name("J. K. Rowling")
					.mail("JKrowling@gmail.com")
					.build());
			authorRepository.save(Author.builder()
					.adress("None")
					.name("Robert Sedgewick & Kevin Wayne")
					.mail("Robert.Kevein@gmail.com")
					.build());
		}
	}

}
