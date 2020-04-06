package LifeGame;

public class InvestmentAccount extends BankAccount{
    private float value;
    private float growthRate;

    public InvestmentAccount(int initialAccountBalance){
        this.value = initialAccountBalance;
        growthRate = 0;
    }

    public void setGrowthRate(float growthRate){
        this.growthRate = growthRate;
    }

    public void advanceYear(){
        value += value * growthRate;
    }
}
