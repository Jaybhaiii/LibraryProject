package com.net.library.jk.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.library.jk.entity.Book;
import com.net.library.jk.entity.User;
import com.net.library.jk.repository.BookRepository;
import com.net.library.jk.repository.UserRepository;



@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	UserRepository userRepository;
	
	 public Book  save(Book book) {
	       
		 return bookRepository.save(book);
	    }
	 
	 public List<Book> findAll() {
	        return bookRepository.findAll();
	    }
	 
	 public Book findById(Long id) {
	        return bookRepository.findById(id).orElse(null);
	    }
	 
	 public void deleteById(Long id) {
	        bookRepository.deleteById(id);
	    }
	 
	 public Book borrowBook(Long bookId, int userId)
	 {
		 Book book =findById(bookId);
		 User user= userRepository.findById(userId).orElse(null);
		 
		 if(book!= null &&  user != null)
		 {
			 book.setBorrowedBy(user);
			 book.setBorrowed(null);
			 return save(book);
		 }
		 return null;
	 }
	 
	 public Book returnBook(Long bookId)
	 {
		 Book book = findById(bookId);
		 if(book != null)
		 {
			        book.setBorrowedBy(null);
		            book.setBorrowed(false);
		            return save(book);
		        
		 }
		 return null;
	 }
}
