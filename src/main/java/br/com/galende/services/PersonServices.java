package br.com.galende.services;

import br.com.galende.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        for (int i=0; i<8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
    public Person findById(String id) {

        logger.info("Finding all people!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname("Vinicius");
        person.setLastname("Galende");
        person.setAdress("Diadema - São Paulo - Brasil");
        person.setGender("Male");

        return person;
    }
    public Person create(Person person) {

        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {

        logger.info("Updating one person!");
        return person;
    }
    public void delete(String id) {
        logger.info("Deleting one person!");
    }
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname("Person name" + i);
        person.setLastname("Last name" + i);
        person.setAdress("Some adress in Brasil" + i);
        person.setGender("Male");

        return person;
    }
}
