public class Human {
    private int age;
    private String firstName;
    private String lastName;

    public Human(){

    }

    public Human(int age, String firstName, String lastName){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge(){
        return age;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
}
