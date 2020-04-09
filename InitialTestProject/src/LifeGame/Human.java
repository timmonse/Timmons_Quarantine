package LifeGame;

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
    private Job job;

    public SavingsAccount savingsAccount;
    public InvestmentAccount investmentAccount;

    public Human(){
        firstName = getRandomFirstName();
        lastName = getRandomLastName();

        age = 0;
        savingsAccount = new SavingsAccount(0);
        investmentAccount = new InvestmentAccount(0);
    }

    public Human(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        age = 0;
        savingsAccount = new SavingsAccount(0);
        investmentAccount = new InvestmentAccount(0);
    }

    public Human(String firstName, String lastName, int initialAccountBalance){
        this.firstName = firstName;
        this.lastName = lastName;

        age = 0;
        savingsAccount = new SavingsAccount(initialAccountBalance);
        investmentAccount = new InvestmentAccount(0);
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
        else if(age > 6 && age <= 9){
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
     * @return Advance age of human by one year
     */
    public void advanceAge(){
        age++;
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
     * Set a job based on the job level
     * @param jobLevel
     */
    public void getJob(int jobLevel){
        job = new Job(jobLevel);
    }

    /**
     * @return Salary of job
     */
    public int getSalary(){
        return job.getSalary();
    }

    /**
     * @return Randomly selected first name from LifeGame.data.java
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
     * @return Randomly selected last name from LifeGame.data.java
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
