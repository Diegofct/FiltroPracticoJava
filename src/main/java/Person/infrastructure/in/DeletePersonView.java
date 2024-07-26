package Person.infrastructure.in;

import java.util.Scanner;

import Menu.MainMenu;
import Person.application.DeletePersonUseCase;

public class DeletePersonView {
    private final DeletePersonUseCase deletePersonUseCase;
    private final Scanner scanner;

    public DeletePersonView(DeletePersonUseCase deletePersonUseCase, Scanner scanner) {
        this.deletePersonUseCase = deletePersonUseCase;
        this.scanner = scanner;
    }

    public void display() {
        System.out.println("=== Eliminar Persona ===");

        int id = 0;
        while (true) {
            System.out.print("Ingrese el ID de la persona a eliminar: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (!deletePersonUseCase.existsById(id)) {
                    System.out.println("No existe una persona con ese ID. Por favor, ingrese un ID válido.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID no válido. Por favor, ingrese un número entero.");
            }
        }

        deletePersonUseCase.deletePerson(id);
        System.out.println("Persona eliminada exitosamente!");
        MainMenu.limpiarPantalla();
    }
    
}
