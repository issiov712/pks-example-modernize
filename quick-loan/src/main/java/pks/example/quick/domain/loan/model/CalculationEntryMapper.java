package pks.example.quick.domain.loan.model;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CalculationEntryMapper {
	public static CalculationEntryMapper INSTANCE = Mappers.getMapper(CalculationEntryMapper.class);

	LoanScheduleEntry mapToLoanScheduleEntry(LoanCalculationEntry entry);
	List<LoanScheduleEntry> mapToLoanScheduleEntryList(List<LoanCalculationEntry> entryList);
}
