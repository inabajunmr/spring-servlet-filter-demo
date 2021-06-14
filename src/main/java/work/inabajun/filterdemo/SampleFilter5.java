package work.inabajun.filterdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Order(5000)
@Component
public class SampleFilter5 extends OncePerRequestFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(SampleFilter5.class);

@Override
protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
    final String filter5 = httpServletRequest.getParameter("filter5");

    if(filter5 != null && filter5.length() != 0) {
        LOGGER.info("SampleFilter5");
        ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(httpServletResponse);
        httpResponse.setStatusCode(HttpStatus.OK);
        httpResponse.getBody().write("SampleFilter5".getBytes(StandardCharsets.UTF_8));
        httpResponse.flush();
    } else {
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
}
