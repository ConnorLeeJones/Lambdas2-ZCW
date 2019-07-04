import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class PersonTests {

    private Person person1;
    private Person person2;

    @Before
    public void setup(){
        person1 = new Person();
        person2 = new Person("Connor", LocalDate.of(1993, 7, 29),
                Person.Sex.MALE, "con@internet.com");
    }


    @Test
    public void printPersonTest(){
        person2.printPerson();
    }

    @Test
    public void getName() {
        Assert.assertEquals(person2.getName(), "Connor");
    }

    @Test
    public void setName() {
        person2.setName("Jim");
        Assert.assertEquals(person2.getName(), "Jim");

    }

    @Test
    public void getBirthday() {
        Assert.assertEquals(person2.getBirthday(), LocalDate.of(1993, 7, 29));
    }

    @Test
    public void setBirthday() {
        person2.setBirthday(LocalDate.of(2000, 1, 1));
        Assert.assertEquals(person2.getBirthday(), LocalDate.of(2000, 1, 1));
    }

    @Test
    public void getGender() {
        Assert.assertEquals(person2.getGender(), Person.Sex.MALE);
    }

    @Test
    public void setGender() {
        person2.setGender(Person.Sex.FEMALE);
        Assert.assertEquals(person2.getGender(), Person.Sex.FEMALE);
    }

    @Test
    public void getEmailAddress() {
        Assert.assertEquals(person2.getEmailAddress(), "con@internet.com");
    }

    @Test
    public void setEmailAddress() {
        person2.setEmailAddress("conboul@yahoo.com");
        Assert.assertEquals(person2.getEmailAddress(), "conboul@yahoo.com");
    }

    @Test
    public void getAge() {
        Assert.assertEquals(person2.getAge(), 25);
    }

    @Test
    public void setAge() {
        person2.setAge(21);
        Assert.assertEquals(person2.getAge(), 21);

    }





}
