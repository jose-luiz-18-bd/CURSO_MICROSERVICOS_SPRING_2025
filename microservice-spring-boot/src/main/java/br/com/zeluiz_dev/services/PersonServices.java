package br.com.zeluiz_dev.services;

import br.com.zeluiz_dev.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public  List<Person> findAll(){

        logger.info("Find All People");

        List<Person> people = new ArrayList<Person>();
        for(int i = 0 ; i < 10 ; i++ ) {
            Person person = mockPerson(i);
            people.add(person);
        }
        return people;
    }

    public Person findById(String id) {

        logger.info("Finding One Person!!!");

        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("José Luiz");
        person.setLastName("de Jesus Santos");
        person.setGender("Male");
        person.setAddress("Uberlândia - MG - Brasil");

        return person;
    }

    public Person create(Person person) {

        logger.info("Creating One Person!!!");

        return person;
    }

    public Person update(Person person) {

        logger.info("Updating One Person!!!");

        return person;
    }

    public void delete(String id){

        logger.info("Deleting One Person!!!");

    }

    private Person mockPerson(int i) {
        Person person = new Person();

        person.setId(counter.incrementAndGet());
        person.setFirstName("First Name: "+ i);
        person.setLastName("Last Name: "+ i);
        person.setGender("Gender: "+ i);
        person.setAddress("Same Address in Brazil: ");
        return person;
    }

}
