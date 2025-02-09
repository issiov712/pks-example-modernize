package pks.example.quick.infrastructure.rest;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import pks.example.quick.domain.loan.model.LoanAggregate;
import pks.example.quick.domain.loan.model.LoanScheduleEntry;

@Mapper(uses = MoneyDataMap.class)
public interface LoanDataMap {
	public static LoanDataMap INSTANCE = Mappers.getMapper(LoanDataMap.class);

	LoanDataObj mapToLoanDataObj(LoanAggregate loan);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "payments", ignore = true)
	LoanAggregate mapToLoanAggregate(LoanDataObj loan);

	List<PaymentDataObj> mapToPaymentDataObj(List<LoanScheduleEntry> payments);
}
