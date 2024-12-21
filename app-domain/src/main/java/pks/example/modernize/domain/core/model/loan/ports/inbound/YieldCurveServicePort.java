package pks.example.modernize.domain.core.model.loan.ports.inbound;

import java.sql.Date;
import java.util.Optional;

public interface YieldCurveServicePort {
    public Optional<Double> getYieldCurveEntry(Date yieldCurveEdition, Date yieldCureveEntryDate);
}
