package Person.infrastructure.in;

import java.util.Scanner;

import Person.domain.service.PersonService;

public class PersonController {
    private final PersonService personService;
    private final CreatePersonView createPersonView;
    private final DeletePersonView deletePersonView;
    private final UpdatePersonView updatePersonView;
    private final Scanner scanner;
    
    public PersonController(PersonService personService, CreatePersonView createPersonView,
            DeletePersonView deletePersonView, UpdatePersonView updatePersonView, Scanner scanner) {
        this.personService = personService;
        this.createPersonView = createPersonView;
        this.deletePersonView = deletePersonView;
        this.updatePersonView = updatePersonView;
        this.scanner = scanner;
    }

    
}
