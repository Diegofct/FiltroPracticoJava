package PersonSkill.domain.entity;

import java.util.Date;

public class PersonSkill {
    private int id;
    private Date registrationDate;
    private int idPerson;
    private int idSkill;

    public PersonSkill() {
    }
    
    public PersonSkill(int id, Date registrationDate, int idPerson, int idSkill) {
        this.id = id;
        this.registrationDate = registrationDate;
        this.idPerson = idPerson;
        this.idSkill = idSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    
}
