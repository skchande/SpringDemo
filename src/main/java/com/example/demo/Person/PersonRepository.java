package com.example.demo.Person;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT s FROM Person s WHERE s.eMail = ?1")
    Optional<Person> findPersonByEMail(String eMail);

}
