package work.inabajun.filterdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class SampleFilter2 implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("SampleFilter2 BEFORE");
        filterChain.doFilter(servletRequest, servletResponse);
        LOGGER.info("SampleFilter2 AFTER");
    }
}
