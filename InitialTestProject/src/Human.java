import java.util.Random;

public class Human {
    private enum LifeStage{
        error, Infancy, Early_Childhood, Middle_Childhood,
        Late_Childhood, Adolescence, Early_Adulthood,
        Midlife, Mature_Adulthood, Late_Adulthood
    }

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

    /**
     *
     * @return a life stage based on age
     */
    public LifeStage getLifeStage(){
        LifeStage currentLifeStage = LifeStage.error;
        if(age >= 0 && age <= 3){
            currentLifeStage = LifeStage.Infancy;
        }
        else if(age > 3 && age <= 6){
            currentLifeStage = LifeStage.Early_Childhood;
        }
        else if(age > 6 && age <= 8){
            currentLifeStage = LifeStage.Middle_Childhood;
        }
        else if(age > 9 && age <= 11){
            currentLifeStage = LifeStage.Late_Childhood;
        }
        else if(age > 12 && age <= 20){
            currentLifeStage = LifeStage.Adolescence;
        }
        else if(age > 20 && age <= 35){
            currentLifeStage = LifeStage.Early_Adulthood;
        }
        else if(age > 35 && age <= 50){
            currentLifeStage = LifeStage.Midlife;
        }
        else if(age > 50 && age <= 80){
            currentLifeStage = LifeStage.Mature_Adulthood;
        }
        else if(age > 80){
            currentLifeStage = LifeStage.Late_Adulthood;
        }

        return currentLifeStage;
    }

    /**
     * @return Age of human
     */
    public int getAge(){
        return age;
    }

    /**
     * @return First name of human
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * @return Last name of human
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * @return Randomly selected first name from data.java
     */
    private String getRandomFirstName(){
        String[] firstNameArray = data.getFirstNames();
        String firstName = "";
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int randName = rand.nextInt(firstNameArray.length);
        firstName = firstNameArray[randName];
        return firstName;
    }

    /**
     * @return Randomly selected last name from data.java
     */
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
