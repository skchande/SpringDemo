package com.example.demo.Person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        System.out.println("Debug: " + person.toString());

        Optional<Person> foundPerson = personRepository.findPersonByEMail(person.getEMail());
        if (foundPerson.isPresent()) {
            throw new IllegalStateException("Email already used.");
        } else {
            personRepository.save(person);
        }

    }

    public void deletePerson(Long personId) {
        if (!personRepository.existsById(personId)) {
            throw new IllegalStateException("person with id: " + personId + " does not exist");
        } else {
            personRepository.deleteById(personId);
        }
    }

    @Transactional
    public void updatePerson(Long personId, String name, String eMail) {

        Person person = personRepository.findById(personId).orElseThrow(
                () -> new IllegalStateException("person with id: " + personId + " does not exist"));
        if (personRepository.findPersonByEMail(eMail).isPresent()) {
            throw new IllegalStateException("Email already used.");
        } else {
            person.setName(name);
            person.setEMail(eMail);
        }
    }

}