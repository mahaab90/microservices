package com.example.author.author.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.author.author.model.Author;
import com.example.author.author.services.AuthorService;


@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
AuthorService authorService;

public AuthorController(AuthorService authorService) {
	this.authorService=authorService;		
	}

	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthors() {
	    List<Author> authors = authorService.getAuthors();
	    return new ResponseEntity<>(authors, HttpStatus.OK);
	}
	@GetMapping({"/{authorName}"})
	public ResponseEntity<Author> getAuthor(@PathVariable String authorName) {
	    return new ResponseEntity<>(authorService.getAuthorById(authorName), HttpStatus.OK);
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
		Author author1 = authorService.insert(author);
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.add("author", "/api/v1/author/" + author1.getName().toString());
	    return new ResponseEntity<>(author1, httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{authorName}"})
	public ResponseEntity<Author> updateAuthor(@PathVariable("authorName") String authorName, @RequestBody Author author) {
	    authorService.updateAuthor(authorName, author);
	    return new ResponseEntity<>(authorService.getAuthorById(authorName), HttpStatus.OK);
	}
	//The function receives a DELETE request, deletes the Author with the specified Id.
	@DeleteMapping({"/{authorName}"})
	public ResponseEntity<Author> deleteAuthor(@PathVariable("authorName") String authorName) {
	    authorService.deleteAuthor(authorName);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
