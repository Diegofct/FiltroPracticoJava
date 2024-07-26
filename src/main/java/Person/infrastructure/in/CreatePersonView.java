package Person.infrastructure.in;

import java.util.Scanner;

import Menu.MainMenu;
import Person.application.CreatePersonUseCase;
import Person.domain.entity.Person;

public class CreatePersonView {

    private final CreatePersonUseCase createPersonUseCase;
    private final Scanner scanner;

    public CreatePersonView(CreatePersonUseCase createPersonUseCase, Scanner scanner) {
        this.createPersonUseCase = createPersonUseCase;
        this.scanner = scanner;
    }

    public void display() {
        System.out.println("=== Registrar Persona ===");

        int id = 0;
        while (true) {
            System.out.print("Registre el id: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (createPersonUseCase.existsById(id)) {
                    System.out.println("Ya existe una persona con el mismo ID. Por favor, ingrese un ID diferente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID no válido. Por favor, ingrese un número entero.");
            }
        }

        System.out.print("Registre el nombre: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        System.out.print("Registre el apellido: ");
        String lastName = scanner.nextLine().trim();
        if (lastName.isEmpty()) {
            System.out.println("El apellido no puede estar vacío.");
            return;
        }

        int cityId = 0;
        while (true) {
            System.out.print("Registre el id de la Ciudad : ");
            try {
                cityId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ciudad ID no válido. Por favor, ingrese un número entero.");
            }
        }

        System.out.print("Registre la dirección de residencia: ");
        String address = scanner.nextLine().trim();
        if (address.isEmpty()) {
            System.out.println("La dirección no puede estar vacía.");
            return;
        }

        int age = 0;
        while (true) {
            System.out.print("Registre la edad: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("Edad no válida. Por favor, ingrese un número positivo.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Edad no válida. Por favor, ingrese un número entero.");
            }
        }

        System.out.print("Registre el email: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()) {
            System.out.println("El email no puede estar vacío.");
            return;
        }

        int genderId = 0;
        while (true) {
            System.out.print("Registre el id del Género : ");
            try {
                genderId = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Género ID no válido. Por favor, ingrese un número entero.");
            }
        }

        Person person = new Person(id, name, lastName, cityId, address, age, email, genderId);
        createPersonUseCase.createPerson(person);

        System.out.println("Persona registrada exitosamente!");
        MainMenu.limpiarPantalla();
    }

    

}
