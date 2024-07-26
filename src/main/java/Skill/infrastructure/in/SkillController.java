package Skill.infrastructure.in;

import java.util.InputMismatchException;
import java.util.Scanner;

import Menu.MainMenu;
import Skill.application.CreateSkillUseCase;
import Skill.domain.service.SkillService;
import Skill.infrastructure.out.SkillRepository;

public class SkillController {

    private final SkillService skillService;
    private final CreateSkillView createSkillView;
    private final Scanner scanner;
    
    public SkillController(Scanner scanner) {
        this.scanner = scanner;
        this.skillService = new SkillRepository();
        CreateSkillUseCase createSkillUseCase = new CreateSkillUseCase(skillService);
        this.createSkillView = new CreateSkillView(createSkillUseCase, scanner);
    }

    public void showMenu() {
        int option;

        while (true) {
            try {
                System.out.println("====== Bienvenido al menú de Skill: ======");
                System.out.println("1. Crear Skill");
                System.out.println("2. Volver menu principal");
                System.out.print("Elige una opción: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> {
                        MainMenu.limpiarPantalla();
                        createSkillView.display();
                    }
                    case 2 -> {
                        MainMenu.limpiarPantalla();
                        return;
                    }
                    default -> System.out.println("Error!, seleccione una opción válida para este menú");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Error, solo se puede digitar un número");
            }
        }
    }
    
}
