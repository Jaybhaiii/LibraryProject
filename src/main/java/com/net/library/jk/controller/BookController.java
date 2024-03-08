package com.net.library.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.library.jk.entity.Book;
import com.net.library.jk.serviceimpl.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/post")
    public com.net.library.jk.entity.Book addBook(@RequestBody Book book) {
        
		return bookService.save(book);
    }
	
	 @GetMapping("/get")
	    public List<Book> getAllBooks() {
	        return bookService.findAll();
	    }
	 
	 @GetMapping("/getSingle/{id}")
	    public Book getBook(@PathVariable Long id) {
	        return bookService.findById(id);
	    }
	 
	 @PutMapping("/update/{id}")
	    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
	        // Additional logic to ensure you're updating the correct book
	        return bookService.save(book);
	    }
	 
	 @DeleteMapping("/{id}")
	    public void deleteBook(@PathVariable Long id) {
	        bookService.deleteById(id);
	    }
	 
	 @PostMapping("/{bookId}/borrow/{userId}")
	    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable int userId) {
	        Book borrowedBook = bookService.borrowBook(bookId, userId);
	        if (borrowedBook != null) {
	            return ResponseEntity.ok(borrowedBook);
	        } else {
	            return ResponseEntity.badRequest().build(); // or a more descriptive error response
	        }
	    }
	 
	 @PostMapping("/{bookId}/return")
	    public ResponseEntity<Book> returnBook(@PathVariable Long bookId) {
	        Book returnedBook = bookService.returnBook(bookId);
	        if (returnedBook != null) {
	            return ResponseEntity.ok(returnedBook);
	        } else {
	            return ResponseEntity.badRequest().build(); // or a more descriptive error response
	        }
	    }
}
