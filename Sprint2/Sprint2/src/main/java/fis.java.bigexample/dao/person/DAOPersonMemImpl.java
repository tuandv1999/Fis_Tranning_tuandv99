package fis.java.bigexample.dao.person;

import fis.java.bigexample.model.Person;

import java.util.List;
import java.util.Optional;

public class DAOPersonMemImpl implements IDAOPerson {

    @Override
    public Optional<Person> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public void save(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }
}
