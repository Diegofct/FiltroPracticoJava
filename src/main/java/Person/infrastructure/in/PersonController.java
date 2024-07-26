package Person.infrastructure.in;

import java.util.InputMismatchException;
import java.util.Scanner;

import Menu.MainMenu;
import Person.application.CreatePersonUseCase;
import Person.application.DeletePersonUseCase;
import Person.application.UpdatePersonUseCase;
import Person.domain.service.PersonService;
import Person.infrastructure.out.PersonRepository;

public class PersonController {
    private final PersonService personService;
    private final CreatePersonView createPersonView;
    private final DeletePersonView deletePersonView;
    private final UpdatePersonView updatePersonView;
    private final Scanner scanner;
    
    public PersonController(Scanner scanner) {
        this.scanner = scanner;
        this.personService = new PersonRepository();
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personService);
        this.createPersonView = new CreatePersonView(createPersonUseCase, scanner);
        DeletePersonUseCase deletePersonUseCase = new DeletePersonUseCase(personService);
        this.deletePersonView = new DeletePersonView(deletePersonUseCase, scanner);
        UpdatePersonUseCase updatePersonUseCase = new UpdatePersonUseCase(personService);
        this.updatePersonView = new UpdatePersonView(updatePersonUseCase, scanner);
    }

    public void showMenu() {
        int option;

        while (true) {
            try {
                System.out.println("====== Bienvenido al menú Persona: ======");
                System.out.println("1. Crear persona");
                System.out.println("2. Actualizar información de una persona");
                System.out.println("3. Eliminar persona");
                System.out.println("4. Volver menu principal");
                System.out.print("Elige una opción: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        MainMenu.limpiarPantalla();
                        createPersonView.display();
                        break;
                    case 2:
                        MainMenu.limpiarPantalla();
                        updatePersonView.display();
                        break;
                    case 3:
                        MainMenu.limpiarPantalla();
                        deletePersonView.display();
                        break;
                    case 4:
                        MainMenu.limpiarPantalla();
                        return;
                    default:
                        System.out.println("Error!, seleccione una opción válida para este menú");
                        break;
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Error, solo se puede digitar un número");
            }
        }
    }



    
}
