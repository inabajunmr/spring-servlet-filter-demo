package work.inabajun.filterdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Order(100)
@Component
public class SampleFilter4 extends OncePerRequestFilter {

    @Autowired
    SampleService service;

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        final String filter4 = httpServletRequest.getParameter("filter4");

        if(filter4 != null && filter4.length() != 0) {
            LOGGER.info("SampleFilter4 BEFORE");
            service.execute();
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            LOGGER.info("SampleFilter4 AFTER");
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}

