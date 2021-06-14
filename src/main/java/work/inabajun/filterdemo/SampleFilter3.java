package work.inabajun.filterdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Order(500)
@Component
public class SampleFilter3 extends GenericFilterBean {

    @Autowired
    SampleService service;

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final String filter3 = servletRequest.getParameter("filter3");
        if(filter3 != null && filter3.length() != 0) {
            LOGGER.info("SampleFilter3 BEFORE");
            service.execute();
            filterChain.doFilter(servletRequest, servletResponse);
            LOGGER.info("SampleFilter3 AFTER");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

