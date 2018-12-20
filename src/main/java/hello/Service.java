package hello;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
@Transactional
public class Service {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired 
	private JobRepository jobRepository;
	
	public String asignarTrabajo() {
		
		Job unTrabajo = null;
		Iterable<Job> jobs = jobRepository.findAll();
		for (Job job : jobs) {
			unTrabajo = job;
			break;
		}
		
		Iterable<Person> personas = personRepository.findAll();
		Person unaPersona = null;
		for (Person person : personas) {
			unaPersona = person;
			break;
		}
		List<Job> aux = new ArrayList<Job>();
		aux.add(unTrabajo);
		unaPersona.setJobs(aux);
		
		entityManager.persist(unaPersona);
		
		return "OK";
		
	}
	
	
}
