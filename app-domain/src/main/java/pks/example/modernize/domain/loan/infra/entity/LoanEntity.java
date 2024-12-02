package pks.example.modernize.domain.loan.infra.entity;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
// import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pks.example.modernize.domain.loan.core.FinancialSchedule;
 
/**
 * 
 * @author Peter Shiner
 * @since 0.1
 */
 /*
  * one idea for a domain object is to just use entities with protected access no argument constructors
  */
@Entity @Getter @Setter @ToString @NoArgsConstructor // (access = AccessLevel.PROTECTED)
@Table(name = "LOAN")
public class LoanEntity {

    @Id @GeneratedValue 
    @Column(name = "PKID")
    private Long id;

    @Version
    @Column(name = "L_VERSION")
    private Long version;

    @Column(name = "D_LOAN_START")
    Date startDate;

    @Column(name = "BD_PRINCIPAL_AMOUNT", scale = 2, precision = 22)
    private BigDecimal principalAmount;

    @Column(name = "BD_INTEREST_RATE", scale = 3, precision = 6)
    private BigDecimal interestRate;

    private FinancialSchedule financialSchedule;

}
