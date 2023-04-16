package tech.alyxbb.AOC2022.day10;

public class Register {
    private int value = 1;
    
    public void increment() {
        value ++;
    }
    public void increment(int amount){
        value +=amount;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
