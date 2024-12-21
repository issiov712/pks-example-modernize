package pks.example.modernize.domain.core.port.inbound;

import java.sql.Date;
import java.util.Optional;

import org.springframework.stereotype.Component;

import pks.example.modernize.domain.core.model.loan.ports.inbound.YieldCurveServicePort;

@Component
public class YieldCurveTestService implements YieldCurveServicePort {
    public Optional<Double> getYieldCurveEntry(Date yieldCurveEdition, Date yieldCureveEntryDate) {
        return Optional.of(Double.valueOf(2.25d));
    }
}
