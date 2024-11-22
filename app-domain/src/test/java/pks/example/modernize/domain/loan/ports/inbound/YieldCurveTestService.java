package pks.example.modernize.domain.loan.ports.inbound;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class YieldCurveTestService implements YieldCurveServicePort {
    public Double getYieldCurveEntry(Date yieldCurveEdition, Date yieldCureveEntryDate) {
        return Double.valueOf(2.25d);
    }
}
