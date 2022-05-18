package com.example.demo.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository) {
        return args -> {
            Person person_1 = new Person(
                    "Chris",
                    LocalDate.of(2000, Month.AUGUST, 5),
                    "chris@testPerson.at");

            Person person_2 = new Person(
                    "Alex",
                    LocalDate.of(2003, Month.AUGUST, 5),
                    "alex@person.at");

            personRepository.saveAll(List.of(person_1, person_2));
        };
    }
}
