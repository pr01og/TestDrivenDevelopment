package com.probojnik.testDrivenDevelopment;

/**
 * @author Stanislav Shamji
 */
public class Money implements Expression{
    public int amount;
    protected String currency;

    public Expression times(int multiplier){
        return new Money(amount*multiplier,currency);
    }
    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }
    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }
    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }
    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount && currency().equals(money.currency());
    }
    public String currency(){
        return this.currency;
    }
    public Expression plus(Expression addend){
        return new Sum(this, addend);
    }
    public Money reduce(Bank bank,String to){
//        int rate = (currency.equals("CHF")&&to.equals("USD"))?2:1;
        int rate = bank.rate(currency,to);
        return new Money(amount/rate, to);
    }
    @Override
    public String toString() {
        return "toString - " + amount + " = " + currency;
    }
}