package br.com.zeluiz_dev.services;

import br.com.zeluiz_dev.exception.ResourceNotFoundException;
import br.com.zeluiz_dev.model.Person;
import br.com.zeluiz_dev.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());
    @Autowired
    PersonRepository repository;

    public  List<Person> findAll(){

        logger.info("Find All People");

        return repository.findAll();

    }

    public Person findById(Long id) {

        logger.info("Finding One Person!!!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" No Records Found For This ID!"));
    }

    public Person create(Person person) {

        logger.info("Creating One Person!!!");

        return repository.save(person);
    }

    public Person update(Person person) {

        logger.info("Updating One Person!!!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException(" No Records Found For This ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){

        logger.info("Deleting One Person!!!");
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" No Records Found For This ID!"));
        repository.delete(entity);

    }

}
