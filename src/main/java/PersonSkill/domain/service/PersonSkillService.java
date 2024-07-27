package PersonSkill.domain.service;

import PersonSkill.domain.entity.PersonSkill;

public interface PersonSkillService {
    void createPersonSkill(PersonSkill personSkill);
    boolean existById(int id);
    PersonSkill consultPersonBySkill(PersonSkill personSkill);
}
