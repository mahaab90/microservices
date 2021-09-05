package com.example.task.crud.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.task.crud.model.Book;
import com.example.task.crud.repositories.BookRepository;

@Component
public class BookLoader implements CommandLineRunner {
public final BookRepository bookRepository;
public BookLoader(BookRepository bookRepository) {
	this.bookRepository=bookRepository;
}
	@Override
	public void run(String... args) throws Exception {
		loadBooks();
		
	}
private void loadBooks() {
	if(bookRepository.count() == 0) {
		bookRepository.save(
                Book.builder()
                        .title("harry potter")
                        .description("magic, adventures")
                        .author("J. K. Rowling")
                        .build()
        );
		bookRepository.save(
                Book.builder()
                        .title("algorithms")
                        .description("computer science, enginneering")
                        .author("Robert Sedgewick & Kevin Wayne")
                        .build()
        );
		
	}
}
}
