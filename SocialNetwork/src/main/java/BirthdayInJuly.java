import java.time.Month;

public class BirthdayInJuly implements CheckPerson{
    public boolean test(Person p){
        return p.getBirthday().getMonth().equals(Month.JULY);
    }
}
