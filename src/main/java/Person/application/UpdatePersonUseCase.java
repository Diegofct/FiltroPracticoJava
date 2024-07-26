package Person.application;

import Person.domain.entity.Person;
import Person.domain.service.PersonService;

public class UpdatePersonUseCase {
    private final PersonService personService;

    public UpdatePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void updatePerson(Person person) {
        personService.updatePerson(person);
    }

    public boolean existsById(int id) {
        return personService.existById(id);
    }
}
