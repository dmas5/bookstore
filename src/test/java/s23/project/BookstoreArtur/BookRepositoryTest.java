package s23.project.BookstoreArtur;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import s23.project.BookstoreArtur.domain.Book;
import s23.project.BookstoreArtur.domain.BookRepository;
import s23.project.BookstoreArtur.domain.Category;
import s23.project.BookstoreArtur.domain.CategoryRepository;

//@DataJpaTest

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookstoreArturApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Autowired
	private CategoryRepository crepository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Sinuhe");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Mika Waltari");
	}

	@Test
	public void createNewBook() {
		Category category = new Category("theatre");
		crepository.save(category);
		Book book = new Book("Hamlet", "William Shakespeare", 1600, "1-2", 15.0, category);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteNewBook() {
		List<Book> books = repository.findByTitle("Sinuhe");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByTitle("Sinuhe");
		assertThat(newBooks).hasSize(0);
	}

}
