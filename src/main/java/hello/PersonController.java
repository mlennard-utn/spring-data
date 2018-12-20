package hello;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired 
	private JobRepository jobRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired 
	private Service service;
	
	@GetMapping("/personas")
	public String getPersons(Model model) {
	
		Iterable<Person> personas = personRepository.findAll();
		
		model.addAttribute("personas", personas);
		Person p = new Person();
		model.addAttribute("person", p);
		return "persons";
	}
	
	@PostMapping(value="/personas", consumes="application/x-www-form-urlencoded;charset=UTF-8")
	public String savePerson(Person persona) {
		Person p = personRepository.save(persona);
		return "persons";
	}
	
	@PostMapping(value="/asignarTrabajo", consumes="application/json", produces="application/json")
	public String asignarTrabajo() {
		
		service.asignarTrabajo();
		
		return "OK";
	}
}
