package pks.example.modernize.domain.core.port.inbound;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YieldCurveServiceTestConfig {
    
    @Bean
    public YieldCurveTestService yieldCurveTestService() {
        return new YieldCurveTestService();
    }
}
