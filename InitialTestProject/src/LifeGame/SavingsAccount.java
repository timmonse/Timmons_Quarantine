package LifeGame;

public class SavingsAccount extends BankAccount {
    private float value;

    public SavingsAccount(int initialAccountBalance){
        this.value = initialAccountBalance;
    }

    public float getValue(){
        return value;
    }

    public void changeValue(float amountToAdd){
        value = value + amountToAdd;
    }

    public void setValue(float value){
        this.value = value;
    }
}
