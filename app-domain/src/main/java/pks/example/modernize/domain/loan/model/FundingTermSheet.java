package pks.example.modernize.domain.loan.model;

import java.sql.Date;

import org.javamoney.moneta.Money;

import lombok.Builder;
import lombok.Getter;

@Builder @Getter
public class FundingTermSheet implements TermSheet {
	String name;
	String description;
	Date startDate;
	Date endDate;
	Date closeDate;
	Money fundingLimit;

}
