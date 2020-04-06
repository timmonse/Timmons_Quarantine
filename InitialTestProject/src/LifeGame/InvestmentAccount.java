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

        //Low risk
        if(risk == 0){
            rate = randFloat(-.01f, .04f);
            riskLevel = risk;
        }
        //Medium risk
        else if(risk == 1){
            rate = randFloat(-.04f, .07f);
            riskLevel = risk;
        }
        //High risk
        else if(risk == 2){
            rate = randFloat(-.11f, .14f);
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
