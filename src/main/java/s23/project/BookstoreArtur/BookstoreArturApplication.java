package s23.project.BookstoreArtur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.project.BookstoreArtur.domain.Book;
import s23.project.BookstoreArtur.domain.BookRepository;

@SpringBootApplication
public class BookstoreArturApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreArturApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreArturApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Hamlet", "William Shakespeare", 1599,4574756,10));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("haetaan kaikki Hamletit");
			for (Book book : repository.findByTitle("Hamlet")) {
				log.info(book.toString());
			}

		};
	}

}
