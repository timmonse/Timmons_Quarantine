import java.util.Random;

public class Human {
    private int age;
    private String firstName;
    private String lastName;

    public Human(){
        firstName = getRandomFirstName();
        lastName = getRandomLastName();
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

    private String getRandomFirstName(){
        String[] firstNameArray = data.getFirstNames();
        String firstName = "";
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int randName = rand.nextInt(firstNameArray.length);
        firstName = firstNameArray[randName];
        return firstName;
    }

    private String getRandomLastName(){
        String[] lastNameArray = data.getLastNames();
        String lastName = "";
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int randName = rand.nextInt(lastNameArray.length);
        lastName = lastNameArray[randName];
        lastName = lastName.toLowerCase();

        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

        return lastName;
    }

}
