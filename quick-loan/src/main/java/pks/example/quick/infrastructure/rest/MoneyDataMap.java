package pks.example.quick.infrastructure.rest;

import java.math.BigDecimal;

import org.javamoney.moneta.Money;

public class MoneyDataMap {


    /**
     * <p>Simple coversion between equivilent types not covered by MapStruct by default.</p>
     * 
     * <p>Assumption is that money is always in "USD."</p>
     * 
     * <p>Note that null values are silently converted to zero ('0').</p>
     * 
     * @param money The money amount as a Money type.
     * @return The amount of money in a database friendly BigDecimal type.
     */
    public BigDecimal mapToBigDecimal(Money money) { return money == null ? Money.of(Double.valueOf(0.00), "USD").getNumberStripped() : money.getNumberStripped(); }

    /**
     * <p>Simple coversion between equivilent types not covered by MapStruct by default.</p>
     * 
     * <p>Assumption is that money is always in "USD."</p>
     * 
     * <p>Note that null values are silently converted to zero ('0').</p>
     * 
     * @param bigDecimal The amount of money in a database friendly BigDecimal type.
     * @return The money amount as a Money type.
     */
    public Money mapToMoney(BigDecimal bigDecimal) { return bigDecimal == null ? Money.of(0.00,"USD") : Money.of(bigDecimal, "USD"); }

	public MoneyDataObj mapToMoneyDataObj(Money money) { return new MoneyDataObj(mapToBigDecimal(money), "USD"); }
	public Money mapToMoney(MoneyDataObj moneyData) { return mapToMoney(moneyData.number()); }

}
