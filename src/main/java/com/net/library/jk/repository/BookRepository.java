package com.net.library.jk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.net.library.jk.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>
{
  
 
}
