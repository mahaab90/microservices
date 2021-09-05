package com.example.task.crud.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.task.crud.model.Author;
import com.example.task.crud.model.Book;
import com.example.task.crud.model.ResponseTemplate;
import com.example.task.crud.repositories.BookRepository;
@Service
public class BookServiceImp implements BookService{
BookRepository bookrepository;
@Autowired
RestTemplate restTemplate;

public BookServiceImp(BookRepository bookrepository) {
	this.bookrepository=bookrepository;
}

	@Override
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		bookrepository.findAll().forEach(books::add);
        return books;
	}

	@Override
	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		return bookrepository.findById(id).get();
	}

	@Override
	public Book insert(Book book) {
		// TODO Auto-generated method stub
		return bookrepository.save(book);
	}

	@Override
	public void updateBook(Long id, Book book) {
		Book bookFromDb = bookrepository.findById(id).get();
		bookFromDb.setDescription(book.getDescription());
		bookFromDb.setAuthor(book.getAuthor());
		bookFromDb.setTitle(book.getTitle());
	        bookrepository.save(bookFromDb);
	}

	@Override
	public void deleteBook(Long bookId) {
		// TODO Auto-generated method stub
		bookrepository.deleteById(bookId);
	}
	@Override
	public ResponseTemplate getBookWithAuthor(Long bookId) {
		ResponseTemplate res=new ResponseTemplate();
		Book book=bookrepository.findById(bookId).get();
		Author author=restTemplate.getForObject("http://AUTHOR-SERVICE/api/v1/author/"+book.getAuthor(),Author.class);
		res.setAuthor(author);res.setBook(book);
		return res;
	}
}
