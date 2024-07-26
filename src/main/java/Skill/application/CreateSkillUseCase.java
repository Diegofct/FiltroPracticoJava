package Skill.application;

import Skill.domain.entity.Skill;
import Skill.domain.service.SkillService;

public class CreateSkillUseCase {
    private final SkillService skillService;

    public CreateSkillUseCase(SkillService skillService) {
        this.skillService = skillService;
    }

    public void createSkill(Skill skill) {
        skillService.createSkill(skill);
    }

    public boolean existById(int id) {
        return skillService.existById(id);
    }
}
