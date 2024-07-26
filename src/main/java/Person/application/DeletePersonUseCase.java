package Person.application;

import Person.domain.service.PersonService;

public class DeletePersonUseCase {
    private final PersonService personService;

    public DeletePersonUseCase(PersonService personService) {
        this.personService = personService;
    }

    public void deletePerson(int id) {
        personService.deletePerson(id);
    }

    public boolean existsById(int id) {
        return personService.existById(id);
    }
}
