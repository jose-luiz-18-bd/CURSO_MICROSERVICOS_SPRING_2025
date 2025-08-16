package br.com.zeluiz_dev.repository;

import br.com.zeluiz_dev.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
