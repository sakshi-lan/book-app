package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Book;


@Repository
public interface BookyDao extends JpaRepository<Book, Integer>{

}