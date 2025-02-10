package pks.example.quick.infrastructure.rest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pks.example.quick.domain.loan.model.LoanAggregate;
import pks.example.quick.domain.loan.model.LoanManager;
import pks.example.quick.domain.loan.model.LoanMethod;
import pks.example.quick.domain.loan.model.LoanMethodType;
import pks.example.quick.domain.loan.model.LoanPeriod;
import pks.example.quick.domain.loan.model.LoanPeriodType;
import pks.example.quick.domain.loan.port.LoanPort;

@Service
public class LoanAdapter {

	public List<LoanDataObj> getAllLoans() {
		List<LoanAggregate> loans = LoanManager.getAllLoans();
		List<LoanDataObj> result = new ArrayList<LoanDataObj>();
		for (LoanAggregate l : loans) {
			result.add(LoanDataMap.INSTANCE.mapToLoanHeaderDataObj(l));
		}
		return result;
	}

	LoanDataObj getLoan(UUID pkid) {
		return LoanDataMap.INSTANCE.mapToLoanDataObj(LoanManager.getLoan(pkid));
	} 
	
	LoanDataObj calculateLoanSchedule(UUID loanId) {
		return LoanDataMap.INSTANCE.mapToLoanDataObj(LoanManager.calculateLoanSchedule(loanId));
	}

	List<PeriodType> getAllPeriodTypes() {
		List<PeriodType> result = new ArrayList<PeriodType>();
		for (LoanPeriod pt : LoanPeriodType.getPeriodTypes()) {
			result.add(new PeriodType(pt.getCode(),pt.getName(), pt.getDescription()));
		}
		return result;
	}

	List<LoanType> getAllLoanTypes() {
		List<LoanType> result = new ArrayList<LoanType>();
		for (LoanMethodType lmt : LoanMethodType.getAllLoanTypes()) {
			result.add(new LoanType(lmt.getCode(),lmt.getName(),lmt.getDescription()));
		}
		return result;
	}

	LoanDataObj createLoan(LoanDataObj loan) {
		LoanAggregate loanAggregate = LoanDataMap.INSTANCE.mapToLoanAggregate(loan);
		loanAggregate = LoanManager.createLoan(loanAggregate);
		LoanManager.calculateLoanSchedule(loanAggregate.getId());
		return LoanDataMap.INSTANCE.mapToLoanDataObj(loanAggregate);
	}

	LoanDataObj updateLoan(String loanId, LoanDataObj loan) {
		LoanAggregate loanAggregate = LoanDataMap.INSTANCE.mapToLoanAggregate(loan);
		loanAggregate = LoanManager.updateLoan(UUID.fromString(loanId), loanAggregate);
		LoanManager.calculateLoanSchedule(loanAggregate.getId());
		return LoanDataMap.INSTANCE.mapToLoanDataObj(loanAggregate);
	}

	void deleteLoan(String loanId) {
		LoanManager.deleteLoan(UUID.fromString(loanId));
	}

	public RateDataObj getInterestRate() {
		return new RateDataObj(LoanManager.getInterestRate());
	}

	public RateDataObj setInterestRate(RateDataObj rate) {
		LoanManager.setInterestRate(rate.rate());
		return rate;
	}

}
