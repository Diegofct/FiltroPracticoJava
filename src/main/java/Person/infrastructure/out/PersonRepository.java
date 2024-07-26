package Person.infrastructure.out;

import Person.domain.entity.Person;
import Person.domain.service.PersonService;

public class PersonRepository implements PersonService{

    @Override
    public void createPerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPerson'");
    }

    @Override
    public void updatePerson(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePerson'");
    }

    @Override
    public void deletePerson(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePerson'");
    }

    @Override
    public Person readPerson(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readPerson'");
    }

    @Override
    public boolean existById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existById'");
    }

    @Override
    public Person findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
