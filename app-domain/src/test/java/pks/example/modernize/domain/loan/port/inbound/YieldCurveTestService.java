package pks.example.modernize.domain.loan.port.inbound;

import java.sql.Date;
import java.util.Optional;

import org.springframework.stereotype.Component;

import pks.example.modernize.domain.loan.port.inbound.YieldCurveServicePort;

@Component
public class YieldCurveTestService implements YieldCurveServicePort {
    public Optional<Double> getYieldCurveEntry(Date yieldCurveEdition, Date yieldCureveEntryDate) {
        return Optional.of(Double.valueOf(2.25d));
    }
}
