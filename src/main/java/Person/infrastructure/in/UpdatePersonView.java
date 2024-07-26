package Person.infrastructure.in;

import java.util.Scanner;

import Person.application.UpdatePersonUseCase;
import Person.domain.entity.Person;

public class UpdatePersonView {
    private final UpdatePersonUseCase updatePersonUseCase;
    private final Scanner scanner;

    public UpdatePersonView(UpdatePersonUseCase updatePersonUseCase, Scanner scanner) {
        this.updatePersonUseCase = updatePersonUseCase;
        this.scanner = scanner;
    }

    public void display() {
        System.out.println("=== Actualizar información de la Persona === ");

        int id = 0;
        while (true) {
            System.out.print("Ingrese el id de la persona a actualizar: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (!updatePersonUseCase.existsById(id)) {
                    System.out.println("No existe una persona con ese ID. Por favor, ingrese un ID válido.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID no válido. Por favor, ingrese un número entero.");
            }
        }

        Person person = updatePersonUseCase.updatePerson(person);

        System.out.println("Deje el campo vacío si no desea cambiar el valor actual.");

        System.out.print("Nombre (" + person.getName() + "): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) {
            person.setName(name);
        }

        System.out.print("Apellido (" + person.getLastname() + "): ");
        String lastName = scanner.nextLine().trim();
        if (!lastName.isEmpty()) {
            person.setLastname(lastName);
        }

        System.out.print("Ciudad ID (" + person.getIdCity() + "): ");
        String cityIdStr = scanner.nextLine().trim();
        if (!cityIdStr.isEmpty()) {
            try {
                int cityId = Integer.parseInt(cityIdStr);
                person.setIdCity(cityId);
            } catch (NumberFormatException e) {
                System.out.println("Ciudad ID no válido. No se cambiará el valor.");
            }
        }

        System.out.print("Dirección (" + person.getAddress() + "): ");
        String address = scanner.nextLine().trim();
        if (!address.isEmpty()) {
            person.setAddress(address);
        }

        System.out.print("Edad (" + person.getAge() + "): ");
        String ageStr = scanner.nextLine().trim();
        if (!ageStr.isEmpty()) {
            try {
                int age = Integer.parseInt(ageStr);
                person.setAge(age);
            } catch (NumberFormatException e) {
                System.out.println("Edad no válida. No se cambiará el valor.");
            }
        }

        System.out.print("Email (" + person.getEmail() + "): ");
        String email = scanner.nextLine().trim();
        if (!email.isEmpty()) {
            person.setEmail(email);
        }

        System.out.print("Género ID (" + person.getIdGender() + "): ");
        String genderIdStr = scanner.nextLine().trim();
        if (!genderIdStr.isEmpty()) {
            try {
                int genderId = Integer.parseInt(genderIdStr);
                person.setIdGender(genderId);
            } catch (NumberFormatException e) {
                System.out.println("Género ID no válido. No se cambiará el valor.");
            }
        }

        updatePersonUseCase.updatePerson(person);
        System.out.println("Información de la persona actualizada exitosamente!");
    }

}

    

