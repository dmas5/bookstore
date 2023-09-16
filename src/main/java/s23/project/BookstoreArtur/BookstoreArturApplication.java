package s23.project.BookstoreArtur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.project.BookstoreArtur.domain.Book;
import s23.project.BookstoreArtur.domain.BookRepository;
import s23.project.BookstoreArtur.domain.Category;
import s23.project.BookstoreArtur.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreArturApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreArturApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreArturApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Poetry"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Adventure"));
			crepository.save(new Category("Biography"));
			
			repository.save(new Book("Sinuhe", "Mika Waltari", 1945,"457363-4756",10.95,crepository.findByName("History").get(0)));
			
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