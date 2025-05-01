package pks.example.quick.domain.loan.model;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalculationEntryMapper {
	public static CalculationEntryMapper INSTANCE = Mappers.getMapper(CalculationEntryMapper.class);

	@Mapping(source = "paymentAmount", target = "amount")
	@Mapping(source = "accruedInterest", target="interest")
	@Mapping(source = "principalPayment", target="principal")
	LoanScheduleEntry mapToLoanScheduleEntry(LoanCalculationEntry entry);
	List<LoanScheduleEntry> mapToLoanScheduleEntryList(List<LoanCalculationEntry> entryList);
}
