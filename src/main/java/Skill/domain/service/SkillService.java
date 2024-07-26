package Skill.domain.service;

import Skill.domain.entity.Skill;

public interface SkillService {
    void createSkill(Skill skill);
    boolean existById(int id);
}
