package Person.application;

import Person.domain.entity.Person;
import Person.domain.service.PersonService;

public class ReadPersonUseCase {
    private final PersonService personService;

    public ReadPersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public Person readPerson(int id) {
        Person person = personService.readPerson(id);
        return person;
    }
}
