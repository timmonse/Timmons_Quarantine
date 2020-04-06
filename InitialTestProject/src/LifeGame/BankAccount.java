package LifeGame;

public abstract class BankAccount {
    private float value;

    public BankAccount(){
    }

    public abstract float getValue();


    public abstract void changeValue(float value);

    public abstract void setValue(float value);
}
