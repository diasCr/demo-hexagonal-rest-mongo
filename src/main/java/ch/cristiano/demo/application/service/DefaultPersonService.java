package ch.cristiano.demo.application.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import ch.cristiano.demo.application.domain.Person;
import ch.cristiano.demo.application.port.in.PersonService;
import ch.cristiano.demo.application.port.out.PersonDao;

@RequestScoped
public class DefaultPersonService implements PersonService {

    @Inject
    protected PersonDao personDao;

    @Override
    public void create(Person person) {
        personDao.persistPerson(person);
    }

    @Override
    public Person readPersonById(Long id) {
        return personDao.find(id);
    }

    @Override
    public Person readPersonByIdString(String id) {
        return personDao.findByIdString(id);
    }

    @Override
    public List<Person> readAllPersons() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Person person) {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
    }

}
