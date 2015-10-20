package pl.kata;

import java.util.Date;

public class Food {
    private String name;
    private Double currentAmount;

    private Double temperature;

    public Food(String name,Double currentAmount) {
        this.name = name;
        this.currentAmount = currentAmount;
    }



    public Food() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }



    public void decreaseAmount(Double amount) throws ZeroAmountException {
        this.currentAmount = this.currentAmount - amount;
        if(this.currentAmount <= 0){
            this.currentAmount = 0.00;
            throw new ZeroAmountException();
        }
    }

    public void increaseAmount(Double amount) {
        this.currentAmount = this.currentAmount + amount;
    }

    Boolean isInTheCooler(){
        if(temperature < 0){
            return true;
        } else {
            return false;
        }
    }
}
