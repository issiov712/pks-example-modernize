package pks.example.modernize.domain.loan.ports.inbound;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YieldCurveServiceTestConfig {
    
    @Bean
    public YieldCurveTestService yieldCurveTestService() {
        return new YieldCurveTestService();
    }
}
