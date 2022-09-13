package ch.cristiano.demo.application.port.in;

import java.util.List;

import ch.cristiano.demo.application.domain.Person;

public interface PersonService {

    public void create(Person person);

    public Person readPersonById(Long id);

    public Person readPersonByIdString(String id);

    public List<Person> readAllPersons();

    public void update(Person person);

    public void delete(Long id);
}
