package s23.project.BookstoreArtur.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s23.project.BookstoreArtur.BookstoreArturApplication;
import s23.project.BookstoreArtur.domain.Book;
import s23.project.BookstoreArtur.domain.BookRepository;

@RestController
public class RestBookController {

	private static final Logger log = LoggerFactory.getLogger(BookstoreArturApplication.class);

	@Autowired
	BookRepository repository;

//  Return list of books
	@GetMapping("/books")
	public Iterable<Book> getBooks() {
		return repository.findAll();
	}

//  Add new book
	@PostMapping("books")
	Book newBook(@RequestBody Book newBook) {
		log.info("added new book: " + newBook);
		return repository.save(newBook);
	}

//  Edit book
	@PutMapping("/books/{id}")
	Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
		log.info("edited book: " + editedBook);
		editedBook.setId(id);
		return repository.save(editedBook);
	}

}
