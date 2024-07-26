package Person.application;

import Person.domain.entity.Person;
import Person.domain.service.PersonService;

public class CreatePersonUseCase {
    private final PersonService personService;

    public CreatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void createPerson(Person person) {
        personService.createPerson(person);
    }

    public boolean existsById(int id) {
        return personService.existById(id);
    }
}
