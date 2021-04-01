package org.bankuish.challenge.filter;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class RequestFilter implements Filter {

    private final static Logger LOG = LoggerFactory.getLogger(RequestFilter.class);

    public void init(final FilterConfig filterConfig) throws ServletException {
        LOG.info("Initializing filter :{}", this);
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        LOG.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
        LOG.info("Logging Request Content: {}", IOUtils.toString(req.getReader()));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        LOG.warn("Destructing filter :{}", this);
    }
}
