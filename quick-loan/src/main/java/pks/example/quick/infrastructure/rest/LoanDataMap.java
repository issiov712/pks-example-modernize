package pks.example.quick.infrastructure.rest;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import pks.example.quick.domain.loan.model.LoanAggregate;
import pks.example.quick.domain.loan.model.LoanPayment;

@Mapper(uses = MoneyDataMap.class)
public interface LoanDataMap {
	public static LoanDataMap INSTANCE = Mappers.getMapper(LoanDataMap.class);

	LoanDataObj mapToLoanDatObj(LoanAggregate loan);
	LoanAggregate mapToLoanAggregate(LoanDataObj loan);
	List<PaymentDataObj> mapToPaymentDataObj(List<LoanPayment> payments);
}
