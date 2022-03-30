package com.example.Diego_bookstore;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Diego_bookstore.web.BookController;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SmokeTesting {

	@Autowired
	 private BookController controller;

	@Test
	 public void contextLoads() throws Exception {
	 assertThat(controller).isNotNull();
	 }
	
}