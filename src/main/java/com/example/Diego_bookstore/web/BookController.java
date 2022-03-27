package com.example.Diego_bookstore.web;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Diego_bookstore.domain.Book;
import com.example.Diego_bookstore.domain.BookRepository;
import com.example.Diego_bookstore.domain.CategoryRepository;


@Controller
public class BookController {

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository drepository;
	
	@RequestMapping("/booklist")	
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	//	RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> BooksListRest() {	
        return (List<Book>) repository.findAll();
    } 
    
    //	RESTful service to get book by id
    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }     
	
	@RequestMapping(value = "/addbook")
	public String addBook(Model model){
	model.addAttribute("book", new Book());
	model.addAttribute("category", drepository.findAll());
	 return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	 repository.save(book);
	 return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")	
	public String deleteBook(@PathVariable("id") Long bookId, Model model){
		repository.deleteById(bookId);
	 return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") Long bookId, Model model) {
	model.addAttribute("book", repository.findById(bookId));
	model.addAttribute("category", drepository.findAll());
	return "editbook";
	}
	
	 @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
	
}
