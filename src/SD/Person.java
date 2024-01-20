package SD;

public class Person {
    private String name;
    private int birthDate;

    public Person(String name, int birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBirthday(){
        return true;
    }
}
