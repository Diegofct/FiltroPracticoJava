package PersonSkill.application;

import PersonSkill.domain.entity.PersonSkill;
import PersonSkill.domain.service.PersonSkillService;

public class ConsultPersonSkillUseCase {
    private final PersonSkillService personSkillService;

    public ConsultPersonSkillUseCase(PersonSkillService personSkillService) {
        this.personSkillService = personSkillService;
    }

    public PersonSkill consultPersonSkill(PersonSkill personSkill) {
        PersonSkill personSkill1 = personSkillService.consultPersonBySkill(personSkill);
        return personSkill1;
    }
}
