package ribbonconfiguration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Ribbon 配置类
 *
 * @author gaofangye
 */
@Configuration
public class RibbonConfiguration {

    /**
     * 自定义 Ribbon 负载均衡的规则
     *
     * @return IRule
     */
    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
