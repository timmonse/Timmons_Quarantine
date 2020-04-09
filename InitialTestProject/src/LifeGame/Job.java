package LifeGame;

public class Job {
    private int salary;
    private String title;
    private int jobLevel;

    public Job(int jobLevel){
        this.jobLevel = jobLevel;
        salary = createSalary();
        title = createTitle();
    }

    //TODO
    private int createSalary(){
        int givenSalary = 0;
        switch(jobLevel){
            case(0):
                givenSalary = 0;
                break;
            case(1):
                givenSalary =16000;
                break;
            case(2):
                givenSalary = 34000;
                break;
            case(3):
                givenSalary = 100000;
                break;
        }
        return givenSalary;
    }

    //TODO
    private String createTitle(){
        String givenTitle = "";
        switch(jobLevel){
            case(0):
                break;
            case(1):
                break;
            case(2):
                break;
        }
        return givenTitle;
    }

    public int getSalary() {
        return salary;
    }

    public String getTitle() {
        return title;
    }
}
