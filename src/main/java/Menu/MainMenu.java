package Menu;

import java.util.Scanner;

import Person.infrastructure.in.PersonController;
import Skill.infrastructure.in.SkillController;

public class MainMenu {

    private PersonController personController;
    private SkillController skillController;
    private Scanner scanner;

    public MainMenu(Scanner scanner) {
        // Inicializa el controlador de personas
        this.personController = new PersonController(scanner);
        this.skillController = new SkillController(scanner);
        this.scanner = scanner;
    }

    public void Start() {
        limpiarPantalla();

        int opcion;
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("=============================================");
                System.out.println("    ¡Bienvenido, ¿Qué desea realizar hoy?    ");
                System.out.println("=============================================");
                System.out.println("1. Gestión de Personas");
                System.out.println("2. Gestión de Habilidades o skills");
                System.out.println("3. Gestión de Habilidades por Persona");
                System.out.println("4. Salir");
                System.out.println("=============================================");
                System.out.print("Elija una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        MainMenu.limpiarPantalla();
                        personController.showMenu();
                        break;
                    case 2:
                        MainMenu.limpiarPantalla();
                        skillController.showMenu();
                        break;
                    case 3:
                        MainMenu.limpiarPantalla();
                    case 4:
                        System.out.println("Saliendo... Vuelva pronto");
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Digite una opción válida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("======================================");
                System.out.println("Formato invalido. Inserta un número!");
                System.out.println("======================================");
                scanner.nextLine();
            }
        }
    }

    public static void limpiarPantalla() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }
}
