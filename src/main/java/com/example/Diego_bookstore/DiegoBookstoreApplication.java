package com.example.Diego_bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Diego_bookstore.domain.Book;
import com.example.Diego_bookstore.domain.BookRepository;
import com.example.Diego_bookstore.domain.Category;
import com.example.Diego_bookstore.domain.CategoryRepository;
import com.example.Diego_bookstore.domain.User;
import com.example.Diego_bookstore.domain.UserRepository;


@SpringBootApplication
public class DiegoBookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(DiegoBookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DiegoBookstoreApplication.class, args);
				
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository drepository, UserRepository urepository) {
		return (args) -> {
			
	drepository.save(new Category ("Horror"));
	drepository.save(new Category ("Love"));
	drepository.save(new Category ("Psychology"));
	drepository.save(new Category ("Spirituality"));
	 
	repository.save(new Book ("A Farewell to Arms", "Ernest Hemingway", 1929, "12321321-21", drepository.findByName("Horror").get(0)));		
	repository.save(new Book("The power of now", "Eckhart Tolle", 1997, "12315487-11", drepository.findByName("Psychology").get(0)));

	User user1 = new User("user",
			"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
			"USER",
			"user@hh.com");
	User user2 = new User("admin",
			"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
			"ADMIN",
			"admin@hh.com");
	
			//urepository.save(user1);
			//urepository.save(user2);
	
	
	System.out.println("fetch all books");
	for (Book book : repository.findAll()) {
		System.out.println(book.toString());
			};
			
	System.out.println("fetch all categories");
	for (Category category : drepository.findAll()) {
		System.out.println(category.toString());
		};
		
		System.out.println(user1.getPasswordHash() +"  "+ user1.getUsername());
		System.out.println(user2.toString());
		};
	}
}

