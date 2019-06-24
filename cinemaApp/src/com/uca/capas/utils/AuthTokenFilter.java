package com.uca.capas.utils;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthTokenFilter extends GenericFilterBean {

    private UserDetailsService customUserDetailService;
    private String authTokenHeaderName = "x-auth-token";

    public AuthTokenFilter(UserDetailsService userDetailsService){
        this.customUserDetailService = userDetailsService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String authToken = httpServletRequest.getHeader(authTokenHeaderName);

            if(StringUtils.hasText(authToken)){
                String username = TokenUtil.getUsernameFromToken(authToken);
                UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

                if(TokenUtil.validateToken(authToken, userDetails)){
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(token);
                }
            }
            chain.doFilter(request, response);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
