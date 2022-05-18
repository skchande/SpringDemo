package com.example.demo.Person;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Person {

    @Id
    @SequenceGenerator(name = "person_sequence", sequenceName = "person_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    private Long id;
    private String name;
    @Transient
    private int age;
    private LocalDate dateOfBirth;
    private String eMail;

    public Person() {

    }

    public Person(Long id, String name, LocalDate dateOfBirth, String eMail) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.eMail = eMail;
    }

    public Person(String name, LocalDate dateOfBirth, String eMail) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.eMail = eMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + this.id +
                ", name=" + this.name + '\'' +
                ", age=" + this.age +
                ", dateOfBirth=" + this.dateOfBirth +
                ", eMail=" + this.eMail + '\'' +
                "}";
    }
    
}
