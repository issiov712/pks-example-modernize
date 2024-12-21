package pks.example.modernize.domain.loan.port.inbound;

import java.sql.Date;
import java.util.Optional;

public interface YieldCurveServicePort {
    public Optional<Double> getYieldCurveEntry(Date yieldCurveEdition, Date yieldCureveEntryDate);
}
