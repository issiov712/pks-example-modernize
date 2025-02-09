package pks.example.quick.infrastructure.rest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.Money;

import pks.example.quick.domain.loan.model.LoanMethodType;
import pks.example.quick.domain.loan.model.LoanPeriodType;

public class MoneyDataMap {

	static MonetaryAmountFormat fmt = MonetaryFormats.getAmountFormat(
		AmountFormatQueryBuilder.of(Locale.US)
			.set("pattern","#,##0.00")
			.set(CurrencyUnit.class,Monetary.getCurrency("USD"))
			.build());

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
    public BigDecimal mapToBigDecimal(Money money) { 
		if (money == null) {
			return Money.of(Double.valueOf(0.00),"USD").getNumberStripped().setScale(2,RoundingMode.HALF_UP);
		 }
		 
		return money.getNumberStripped().setScale(2,RoundingMode.HALF_UP);
	}

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

	public String mapToString(Money money) {
		if (money == null) {
			return "";
		}
		return fmt.format(money);
	}

	public Money mapToMoney(final String str) {
		if (str == null) {
			return Money.of(0,"USD");
		}
		return Money.parse(str, fmt);
	}

	LoanMethodType mapToLoanMethodType(final String string) { return LoanMethodType.fromCode(string); }
	LoanPeriodType mapToLoanPeriodType(final String string) { return LoanPeriodType.fromCode(string); }
	String mapToString(final LoanMethodType method) { return method.getCode(); }
	String mapToString(final LoanPeriodType period) { return period.getCode(); }

}
