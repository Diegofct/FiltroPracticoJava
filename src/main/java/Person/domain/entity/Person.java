package Person.domain.entity;

public class Person {
    private int id;
    private String name;
    private String lastname;
    private int idCity;
    private String address;
    private int age;
    private String email;
    private int idGender;

    public Person() {
    }

    public Person(int id, String name, String lastname, int idCity, String address, int age, String email,
            int idGender) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.idCity = idCity;
        this.address = address;
        this.age = age;
        this.email = email;
        this.idGender = idGender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    
    
}
