package pks.example.modernize.domain.loan.ports.inbound;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class YieldCurveServicePortTest {
    private final YieldCurveTestService yieldCurveService = new YieldCurveTestService();

    @Test
    void checkYieldCurve() {
        Double rate = yieldCurveService.getYieldCurveEntry(Date.valueOf("2024-11-21"),Date.valueOf("2024-12-21"));
        assertEquals(2.25,rate);
    }
}
