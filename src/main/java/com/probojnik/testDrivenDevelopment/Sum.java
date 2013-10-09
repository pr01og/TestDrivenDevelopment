package com.probojnik.testDrivenDevelopment;

/**
 * @author Stanislav Shamji
 */
public class Sum implements Expression {
    Expression augend, addend;

    public Sum(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend;
    }
    public Money reduce(Bank bank, String to){
//        int rate = (currency.equals("CHF")&&to.equals("USD"))?2:1;
        int amount = augend.reduce(bank,to).amount + addend.reduce(bank,to).amount;
        return new Money(amount,to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}