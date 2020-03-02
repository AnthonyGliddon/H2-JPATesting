package com.nttdata.jpah2test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.jpah2test.model.Book;
import com.nttdata.jpah2test.repository.BookRepository;

@SpringBootApplication
public class StartApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("StartApplication...");

		repository.save(new Book("Java"));
		repository.save(new Book("Node"));
		repository.save(new Book("Python"));

		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(1L)");
		repository.findById(1l).ifPresent(x -> System.out.println(x));

		System.out.println("\nfindByName('Node')");
		repository.findByName("Node").forEach(x -> System.out.println(x));
		
		System.out.println("\ndeleteById('1L')");
		repository.deleteById(1L);
		
		
		repository.findAll().forEach(x -> System.out.println(x));
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}