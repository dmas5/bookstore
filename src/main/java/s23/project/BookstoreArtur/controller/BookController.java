package s23.project.BookstoreArtur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s23.project.BookstoreArtur.domain.Book;
import s23.project.BookstoreArtur.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository; 
	
    @RequestMapping(value= {"/", "/booklist"})
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
  
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }
//  @RequestMapping(value = "/saveedit", method = RequestMethod.POST)
//  public String addEditedStudent(Book book,Model model) {
//	  
//  		model.addAttribute("book",book);
//      return "booklist";
//  }
	


}
