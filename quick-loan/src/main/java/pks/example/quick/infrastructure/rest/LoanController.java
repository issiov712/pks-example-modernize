package pks.example.quick.infrastructure.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/loan")
public class LoanController {

	private final LoanAdapter service;

	@Autowired
	public LoanController(final LoanAdapter loanAdapter) {
		this.service = loanAdapter;
	}

	@GetMapping("/")
	public List<LoanDataObj> getAllLoans() {
		return service.getAllLoans();
	}

	// @GetMapping("/{loanId}")
	// public LoanDataObj getLoan(@PathVariable UUID loanId) {
	// 	return new LoanDataObj();
	// }

	// @GetMapping("/{loanId}/payments")
	// public LoanDataObj getLoanAndPayments(@PathVariable UUID loanId) {
	// 	return new LoanDataObj();
	// }

	@DeleteMapping("/{loanId}")
	public void deleteLoan(@PathVariable UUID loanId) {
		return;
	}

	@PostMapping("/")
	public String postMethodName(@RequestBody String entity) {
		return entity;
	}

	@PutMapping("/{loanId}")
	public String putMethodName(@PathVariable String loanId, @RequestBody String entity) {
		return entity;
	}

	@GetMapping("/periodTypes")
	public List<PeriodType> getPeriodTypes() {
		return service.getAllPeriodTypes();
	}

	@GetMapping("/loanTypes")
	public List<LoanType> getLoanTypes() {
		return service.getAllLoanTypes();
	}

}
