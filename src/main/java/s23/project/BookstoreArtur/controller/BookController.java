package s23.project.BookstoreArtur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s23.project.BookstoreArtur.domain.Book;

@Controller
public class BookController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("friend", new Book());
		return "index";
	}

}
