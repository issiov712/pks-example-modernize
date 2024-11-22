package pks.example.modernize.domain.loan.ports.inbound;

import java.sql.Date;

public interface YieldCurveServicePort {
    public Double getYieldCurveEntry(Date yieldCurveEdition, Date yieldCureveEntryDate);
}
