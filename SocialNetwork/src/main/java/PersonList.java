import java.util.List;

public class PersonList {

    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static String personString(List<Person> roster, CheckPerson tester) {
        StringBuilder result = new StringBuilder();
        for (Person p : roster) {
            if (tester.test(p)) {
                result.append(p.personString());
                result.append("\n");
            }
        }
        return result.toString();
    }

}
