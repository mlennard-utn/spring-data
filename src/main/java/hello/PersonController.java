package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/personas")
	public String getPersons(Model model) {
	
		Iterable<Person> personas = personRepository.findAll();
		
		model.addAttribute("personas", personas);
		
		return "persons";
	}
	
}
