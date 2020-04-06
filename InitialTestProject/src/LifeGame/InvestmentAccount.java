package LifeGame;

public class InvestmentAccount extends BankAccount{
    private float value;
    private float rate;

    public InvestmentAccount(int initialAccountBalance){
        this.value = initialAccountBalance;
        rate = 0;
    }

    public void setRate(float rate){
        this.rate = rate;
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

}
