package work.inabajun.filterdemo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

@Configuration
public class SampleConfiguration {

    @Bean
    FilterRegistrationBean filter2() {
        var filter = new FilterRegistrationBean(new SampleFilter2());
        filter.addUrlPatterns("/sample");
        filter.setOrder(200);
        return filter;
    }
}
