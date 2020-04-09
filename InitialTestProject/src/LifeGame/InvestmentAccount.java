package LifeGame;

import java.util.Random;

public class InvestmentAccount extends BankAccount{
    private float value;
    private float rate;
    private int riskLevel = 0;

    public InvestmentAccount(int initialAccountBalance){
        this.value = initialAccountBalance;
        rate = 0;
    }

    public void setRate(float rate){
        this.rate = rate;
    }

    public float getRate(){
        return this.rate;
    }

    public float getValue(){
        return value;
    }

    public void advanceYear(){
        value += value * rate;
    }

    public void changeValue(float amountToAdd){
        value = value + amountToAdd;
    }

    public void setValue(float value){
        this.value = value;
    }

    public void resetRisk(){
        setRisk(riskLevel);
    }

    public void setRisk(int risk){
        float rate = 0;
        float randLose = 0;

        //Low risk
        if(risk == 0){
            rate = randFloat(-.01f, .05f);
            riskLevel = risk;
        }
        //Medium risk
        else if(risk == 1){
            randLose = randFloat(0.00f, 1.00f);
            //10% chance of losing 0 - 20%
            if(randLose <= 0.10f){
                rate = randFloat(-.20f, 0f);
            }
            //90% Chance of making between 5 and 15%
            else{
                rate = randFloat(.0f, .15f);
            }
            riskLevel = risk;
        }
        //High risk
        else if(risk == 2){
            randLose = randFloat(0.00f, 1.00f);
            //1% chance of losing 99%
            if(randLose <= 0.01f){
                rate = -.99f;
            }
            //10% chance of losing 0 - 50%
            else if(randLose <= 0.11f){
                rate = randFloat(-.50f, 0f);
            }
            //90% Chance of making between 0 and 30%
            else{
                rate = randFloat(0.0f, .30f);
            }
            riskLevel = risk;
        }
        setRate(rate);
    }

    /**
     * Helper method for floats
     * @param min float value
     * @param max float value
     * @return random float
     */
    public static float randFloat(float min, float max) {
        Random rand = new Random();
        return rand.nextFloat() * (max - min) + min;
    }

}
