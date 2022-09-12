package ch.cristiano.demo.adapter.persistence.entity;

import ch.cristiano.demo.application.domain.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "AGE")
    private int age;

    public PersonEntity() {
    }

    public PersonEntity(Long id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonEntity ofDomain(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstname(person.getFirstname());
        personEntity.setLastname(person.getLastname());
        personEntity.setAge(this.age);
        return personEntity;
    }

    public Person toDomain() {
        Person person = new Person();
        person.setFirstname(this.firstname);
        person.setLastname(this.lastname);
        person.setAge(this.age);
        return person;
    }
}
