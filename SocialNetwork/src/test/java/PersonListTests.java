import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;
import java.util.ArrayList;

public class PersonListTests {


    private ArrayList<Person> personList;


    @Before
    public void setup() {
        personList = new ArrayList<>();

        Person person1 = new Person("Connor", LocalDate.of(1993, 7, 8),
                Person.Sex.MALE, "con@internet.com");
        personList.add(person1);
        Person person2 = new Person("Amanda", LocalDate.of(1990, 9, 2),
                Person.Sex.FEMALE, "Adam@internet.com");
        personList.add(person2);
        Person person3 = new Person("Zolio", LocalDate.of(1802, 3, 19),
                Person.Sex.MALE, "Zolio@internet.com");
        personList.add(person3);
        Person person4 = new Person("Barb", LocalDate.of(1980, 1, 9),
                Person.Sex.FEMALE, "Bob@internet.com");
        personList.add(person4);
        Person person5 = new Person("Xander", LocalDate.of(2001, 7, 22),
                Person.Sex.MALE, "Xander@internet.com");
        personList.add(person5);
        Person person6 = new Person("Adam", LocalDate.of(1950, 3, 27),
                Person.Sex.MALE, "Adam@internet.com");
        personList.add(person6);
    }

    @After()
    public void tearDown(){
        personList.clear();
    }


    @Test
    public void personListSizeTest() {
        Assert.assertEquals(personList.size(), 6);
    }

    @Test
    public void personListAddTest() {
        personList.add(new Person());
        Assert.assertEquals(personList.size(), 7);
    }

    @Test
    public void personListRemoveTest() {
        personList.remove(personList.get(0));
        Assert.assertEquals(personList.size(), 5);
    }

    @Test
    public void personListSearchTestJuly() {
        String expected = "Name: Connor\n" +
                "Birthday: 1993-07-08\n" +
                "Gender: MALE\n" +
                "Email: con@internet.com\n" +
                "Age: 25\n" +
                "\n" +
                "Name: Xander\n" +
                "Birthday: 2001-07-22\n" +
                "Gender: MALE\n" +
                "Email: Xander@internet.com\n" +
                "Age: 17\n\n";

        Assert.assertEquals(expected, PersonList.personString(personList, new BirthdayInJuly()));
    }

    @Test
    public void personListSearchTestOver30() {
        String expected = "Name: Zolio\n" +
                "Birthday: 1802-03-19\n" +
                "Gender: MALE\n" +
                "Email: Zolio@internet.com\n" +
                "Age: 217\n" +
                "\n" +
                "Name: Barb\n" +
                "Birthday: 1980-01-09\n" +
                "Gender: FEMALE\n" +
                "Email: Bob@internet.com\n" +
                "Age: 39\n" +
                "\n" +
                "Name: Adam\n" +
                "Birthday: 1950-03-27\n" +
                "Gender: MALE\n" +
                "Email: Adam@internet.com\n" +
                "Age: 69\n\n";

        Assert.assertEquals(expected, PersonList.personString(personList, new Over30()));
    }

    @Test
    public void personListSearchTestAnon() {
        CheckPerson anonCheck = new CheckPerson() {
            public boolean test(Person p) {
                return p.getName().startsWith("A");
            }
        };

        String expected = "Name: Amanda\n" +
                "Birthday: 1990-09-02\n" +
                "Gender: FEMALE\n" +
                "Email: Adam@internet.com\n" +
                "Age: 28\n" +
                "\n" +
                "Name: Adam\n" +
                "Birthday: 1950-03-27\n" +
                "Gender: MALE\n" +
                "Email: Adam@internet.com\n" +
                "Age: 69\n\n";

        Assert.assertEquals(expected, PersonList.personString(personList, anonCheck));
    }

    @Test
    public void personListSearchTestLambda() {
        String expected = "Name: Amanda\n" +
                "Birthday: 1990-09-02\n" +
                "Gender: FEMALE\n" +
                "Email: Adam@internet.com\n" +
                "Age: 28\n" +
                "\n" +
                "Name: Barb\n" +
                "Birthday: 1980-01-09\n" +
                "Gender: FEMALE\n" +
                "Email: Bob@internet.com\n" +
                "Age: 39\n" +
                "\n";

        Assert.assertEquals(expected, PersonList.personString(personList,
                p -> p.getGender().equals(Person.Sex.FEMALE)));
    }

}
