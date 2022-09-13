package ch.cristiano.demo.adapter.persistence.document;

import ch.cristiano.demo.application.domain.Person;

public class PersonDocument {

    private String id;
    private String firstname;
    private String lastname;
    private String age;

    public PersonDocument() {
    }

    public PersonDocument(String id, String firstname, String lastname, String age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public PersonDocument ofDomain(Person person) {
        PersonDocument personDocument = new PersonDocument();
        personDocument.setFirstname(person.getFirstname());
        personDocument.setLastname(person.getLastname());
        personDocument.setAge(this.age);
        return personDocument;
    }

    public Person toDomain() {
        Person person = new Person();
        person.setFirstname(this.firstname);
        person.setLastname(this.lastname);
        person.setAge(Integer.valueOf(this.age));
        return person;
    }

}
