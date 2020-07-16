package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Book;
import com.cg.entity.Category;
import com.cg.service.CategoryService;
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@PostMapping("/create")
	public ResponseEntity<Category> addCategory(@RequestBody Category category ) {
			Category cat=service.addCategory(category);
			ResponseEntity<Category> responseEntity = new ResponseEntity<Category>(cat,HttpStatus.OK);
			return responseEntity;
		}

	
	@PostMapping("/createbook")
	public Book addBook(@RequestBody Book book ) {
			Book b=service.addBook(book);
			//ResponseEntity<Book> responseEntity = new ResponseEntity<Book>(b,HttpStatus.OK);
			return b;
		}
	
	//delete Book
	@DeleteMapping("/delete_book/{id}")
	public void deleteBook(@PathVariable ("id") int id){
	service.deleteBook(id);
	
	}		
	
	@PutMapping("/assignBookToCat/{CategoryId}/{book_id}")
	public Book assignbooktoC(@PathVariable(value="CategoryId")int CategoryId,
			@PathVariable(value="book_id")int book_id) {
		return service.btoC(CategoryId, book_id);
		
	}
	
	@PutMapping("/UpdateCategory")
	public Category updateC(@RequestBody Category category) {
		return service.UpdateCategory(category);
		
	}
	
	@GetMapping("/category/{CategoryId}")
	private Optional<Category> getCategory(@PathVariable("CategoryId") int CategoryId) {
		Optional<Category> cat=service.getCategoryById(CategoryId);
		return cat;
		
	}
	
	@GetMapping("/GetAllCategory")
	private ResponseEntity<List<Category>> getAllCategory() {
		List<Category> catlist = service.getAllCategory();
		return new ResponseEntity<List<Category>>(catlist, new HttpHeaders(), HttpStatus.OK);

	}
	
	@PutMapping("/UpdateBook")
	public Book updateBook(@RequestBody Book book) {
		Book b = service.updateBook(book);
		return b;
	}
	
	@GetMapping("/GetAllBook")
	private ResponseEntity<List<Book>> getAllBook() {
		List<Book> booklist = service.listOfBook();
		return new ResponseEntity<List<Book>>(booklist, new HttpHeaders(), HttpStatus.OK);

	}
	
	
}