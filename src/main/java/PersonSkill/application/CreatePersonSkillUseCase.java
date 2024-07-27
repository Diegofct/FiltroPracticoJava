package PersonSkill.application;

import PersonSkill.domain.entity.PersonSkill;
import PersonSkill.domain.service.PersonSkillService;

public class CreatePersonSkillUseCase {
    private final PersonSkillService personSkillService;

    public CreatePersonSkillUseCase(PersonSkillService personSkillService) {
        this.personSkillService = personSkillService;
    }

    public void createPersonSkill(PersonSkill personSkill) {
        personSkillService.createPersonSkill(personSkill);
    }

    public boolean existsById(int id) {
        return personSkillService.existById(id);
    }
}
