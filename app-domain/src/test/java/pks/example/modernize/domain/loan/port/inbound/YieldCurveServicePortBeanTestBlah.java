package pks.example.modernize.domain.loan.port.inbound;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.annotation.ComponentScan;

import java.sql.Date;
import java.util.Optional;

// @SpringBootTest(classes = Application.class)
// @ComponentScan("pks.example")
public class YieldCurveServicePortBeanTestBlah {
    private final YieldCurveTestService yieldCurveService = new YieldCurveTestService();

    // @Autowired
    // YieldCurveServicePortBeanTestBlah(YieldCurveTestService yieldCurveService) {
    //     this.yieldCurveService = yieldCurveService;
    // }

    @Test
    void checkYieldCurve() {
        Optional<Double> rate = yieldCurveService.getYieldCurveEntry(Date.valueOf("2024-11-21"),Date.valueOf("2024-12-21"));
        assertEquals(2.25,rate.get());
    }
}
