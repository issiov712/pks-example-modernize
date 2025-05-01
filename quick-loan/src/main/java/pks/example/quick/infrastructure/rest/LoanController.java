package pks.example.quick.infrastructure.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/loan")
public class LoanController {

	private final LoanAdapter service;

	@Autowired
	public LoanController(final LoanAdapter loanAdapter) {
		this.service = loanAdapter;
	}

	/*
	 * All loans. no searchable finder, expect that to be in the grid in
	 * this first tiny mvp-demo.
	 */
	@GetMapping("/")
	public List<LoanDataObj> getAllLoans() {
		return service.getAllLoans();
	}

	@GetMapping("/{loanId}")
	public LoanDataObj getLoan(@PathVariable UUID loanId) {
		return service.getLoan(loanId);
	}

	@GetMapping("/{loanId}/calculate")
	public LoanDataObj getLoanAndPayments(@PathVariable UUID loanId) {
		return service.calculateLoanSchedule(loanId);
	}

	@DeleteMapping("/{loanId}")
	public void deleteLoan(@PathVariable String loanId) {
		service.deleteLoan(loanId);
	}

	/*
	 * Create a loan.  Interest is inherited from current rate.  A payment
	 * schedule is automatically created based on the specified loan
	 * calculation type and loan period type selected from the lookup endpoints.
	 */
	@PostMapping("/")
	public LoanDataObj postMethodName(@RequestBody LoanDataObj loan) {
		return service.createLoan(loan);
	}

	@PutMapping("/{loanId}")
	public LoanDataObj putMethodName(@PathVariable String loanId, @RequestBody LoanDataObj loan) {
		return service.updateLoan(loanId, loan);
	}

	/*
	 * Lookup list for the period of the loan.  Monthly, Quarterly, etc.
	 */
	@GetMapping("/type/period")
	public List<PeriodType> getPeriodTypes() {
		return service.getAllPeriodTypes();
	}

	/*
	 * Lookup list for the type of loan calculation to use.
	 */
	@GetMapping("/type/method")
	public List<LoanType> getLoanTypes() {
		return service.getAllLoanTypes();
	}

	/*
	 * Get the current interest rate.  This is because a loan inherits the
	 * currrent interest rate when calculated.  So interest rate is a 
	 * read-only or provided data field, not directly set via a loan creation
	 * or update.
	 */
	@GetMapping("/setting/interest-rate")
	public RateDataObj getLoanInterestRate() {
		return service.getInterestRate();
	}

	/*
	 * Set the current interest rate to apply to all new or updated loans.
	 */
	@PostMapping("/setting/interest-rate")
	public RateDataObj setLoanInterestRate(@RequestBody RateDataObj rate) {
		service.setInterestRate(rate);
		return rate;
	}

}
