package org.bankuish.challenge.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    public FilterRegistrationBean<RequestFilter> loggingFilter() {
        FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestFilter());
        registrationBean.addUrlPatterns("/characters/*");
        return registrationBean;
    }
}
