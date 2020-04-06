package LifeGame;

public abstract class BankAccount {
    private float value;

    public BankAccount(){
    }

    public float getValue(){
        return value;
    }

    public void changeValue(int amountToAdd){
        value = value + amountToAdd;
    }
}
