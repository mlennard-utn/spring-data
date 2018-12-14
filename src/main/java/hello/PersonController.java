package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
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
	
}
