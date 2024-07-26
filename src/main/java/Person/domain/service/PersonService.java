package Person.domain.service;

import Person.domain.entity.Person;

public interface PersonService {
    void createPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int id);
    Person readPerson(int id);
    boolean existById(int id);
}
