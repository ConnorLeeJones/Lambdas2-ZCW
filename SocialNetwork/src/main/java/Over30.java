public class Over30 implements CheckPerson{
    public boolean test(Person p){
        return p.getAge() > 30;
    }
}