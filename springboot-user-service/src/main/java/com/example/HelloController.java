package com.example;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Person;
import com.example.repo.PersonRepository;

@RestController
public class HelloController{
	
	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hello, %s!";
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private PersonRepository personRepo;

	@RequestMapping("/")
	public String index(){
		return "hello";
	}
	
	@RequestMapping("/add")
	public void add(@RequestParam(defaultValue="world") String name ){
		log.info("greeting...");
		Person per = new Person();
		per.setName("Haha" + name);
		personRepo.save(per);
		
	}
	
	@RequestMapping("/list")
	public Iterable<Person> list(){
		Iterable<Person> list = personRepo.findAll();
		
		return list;
	}
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(defaultValue="world", value="desc") String name ){
		log.info("greeting...");
		Iterable<Person> list = personRepo.findAll();
		for(Person p : list){
			log.info(p);
		}
		
		return new Greeting(counter.incrementAndGet(),
                String.format(template, name), name) ;
	}
	
	
}