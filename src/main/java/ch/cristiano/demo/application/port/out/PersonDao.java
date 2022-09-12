package ch.cristiano.demo.application.port.out;

import ch.cristiano.demo.application.domain.Person;

public interface PersonDao {

    public void persistPerson(Person person);

    public Person find(Long id);
}
