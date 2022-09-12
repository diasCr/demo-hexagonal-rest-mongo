package ch.cristiano.demo.adapter.rest.dto;

import ch.cristiano.demo.application.domain.Person;

public class PersonDto {

    private Long id;
    private String firstname;
    private String lastname;

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

    public PersonDto ofDomain(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setFirstname(person.getFirstname());
        personDto.setLastname(person.getLastname());
        return personDto;
    }

    public Person toDomain() {
        Person person = new Person();
        person.setFirstname(this.firstname);
        person.setLastname(this.lastname);
        return person;
    }
}
