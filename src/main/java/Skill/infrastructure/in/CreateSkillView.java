package Skill.infrastructure.in;

import java.util.Scanner;

import Menu.MainMenu;
import Skill.application.CreateSkillUseCase;
import Skill.domain.entity.Skill;

public class CreateSkillView {
    private final CreateSkillUseCase createSkillUseCase;
    private final Scanner scanner;

    public CreateSkillView(CreateSkillUseCase createSkillUseCase, Scanner scanner) {
        this.createSkillUseCase = createSkillUseCase;
        this.scanner = scanner;
    }

    public void display() {
        System.out.println("=== Crear nueva habilidad ===");

        int id = 0;
        while (true) {
            System.out.println("Registre el id del Skill: ");
            try {
                id = Integer.parseInt(scanner.nextLine());
                if (createSkillUseCase.existById(id)) {
                    System.out.println("Ya existe un Skill con el mismo ID. Por favor, ingrese un ID diferente");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID no válido. Por favor, ingrese un número entero.");
            }
        }

        System.out.println("Registre el nombre del Skill: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("El campo nombre no puede quedar vacío");
            return;
        }

        //Creamos un nuevo Skill
        Skill skill = new Skill(id, name);
        createSkillUseCase.createSkill(skill);

        System.out.println("Skill registrado exitosamente!");
        MainMenu.limpiarPantalla();

    }

    
}
