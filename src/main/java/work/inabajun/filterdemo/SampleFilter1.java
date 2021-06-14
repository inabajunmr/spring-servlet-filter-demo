package work.inabajun.filterdemo;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@Order(50)
public class SampleFilter1 implements Filter {

    @Autowired
    SampleService service;

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    final String filter1 = servletRequest.getParameter("filter1");

    if(filter1 != null && filter1.length() != 0) {
        LOGGER.info("SampleFilter1 BEFORE");
        service.execute();
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("SampleFilter1 AFTER");
    } else {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
}
