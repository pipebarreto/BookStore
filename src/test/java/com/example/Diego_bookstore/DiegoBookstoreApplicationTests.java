package com.example.Diego_bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Diego_bookstore.domain.Book;
import com.example.Diego_bookstore.domain.BookRepository;
import com.example.Diego_bookstore.domain.Category;
import com.example.Diego_bookstore.domain.CategoryRepository;
import com.example.Diego_bookstore.web.BookController;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.IntPredicate;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class DiegoBookstoreApplicationTests {
	
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;

	@Test
	public void CreateCategory() {		
		Category category = new Category ("Horror");	
		crepository.save (category);
		assertThat(category.getCategoryId()).isNotNull();	
	}
	 
	@Test
	public void CreateBook() {		
		Book book = new Book ("The Bible", "Good", 500,"12315487-10", 				
				crepository.findByName("Spirituality").get(0));		
		brepository.save(book);	
		assertThat(book.getId()).isNotNull();			
	}
	
	@Test
	public void DeleteBook() {			
		Book book  = new Book();		
		brepository.save(book);	
		int count1=0;
		int count2=0;		
		for (Book book1: brepository.findAll()) {
			count1++;
				};
								
		brepository.deleteById(book.getId());	
		
		for (Book book2: brepository.findAll()) {
			count2++;
				};	
				
		assertThat(count1).isEqualTo(count2+1);	
	}
	
	@Test
	public void findByTitler() {		
	List <Book> books = brepository.findByTitle("The power of now");
	assertThat(books.get(0).getAuthor()).isEqualTo("Eckhart Tolle");
	}	
}
