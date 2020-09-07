package com.kappakorp.hikaricp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Prehandle request");

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://run.mocky.io/v3/47766b8a-e08a-43a7-b2e7-0b6e32456634";
        ResponseEntity<String> responseabc
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        System.out.println(responseabc.toString());

        TenantContextHolder.setTenantType(request.getHeader("tenant"));
        return super.preHandle(request, response, handler);
    }
}
