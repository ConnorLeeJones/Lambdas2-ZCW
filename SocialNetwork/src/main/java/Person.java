import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;
    private LocalDate birthday;
    private Sex gender;
    private String emailAddress;
    private Integer age;


    Person(){
        this("", LocalDate.now(), null, null);
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
        this.age = Period.between(this.birthday, LocalDate.now()).getYears();
    }


    public enum Sex {
        MALE, FEMALE
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public int getAge() {
        return age;
    }

    public void printPerson() {
        System.out.println(personString());
    }

    public String personString() {
        return "Name: " + this.name +
                "\nBirthday: " + this.birthday +
                "\nGender: " + this.gender +
                "\nEmail: " + this.emailAddress +
                "\nAge: " + this.age + "\n";
    }


}