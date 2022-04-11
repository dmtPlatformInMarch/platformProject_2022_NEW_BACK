package com.example.demo.config.security.filter;

import com.example.demo.config.security.token.ApiAuthenticationToken;
import com.example.demo.config.security.util.WebUtil;
import com.example.demo.module.account.domain.dto.AccountLoginDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApiLoginProcessingFilter extends AbstractAuthenticationProcessingFilter {
    private ObjectMapper objectMapper = new ObjectMapper();

    public ApiLoginProcessingFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response)
        throws AuthenticationException, IOException {
        if (!HttpMethod.POST.name().equals(request.getMethod()) || !WebUtil.isApi(request)) {
            throw new IllegalArgumentException("Authentication method not supported");
        }

        AccountLoginDto accountForm = objectMapper.readValue(request.getReader(), AccountLoginDto.class);

        if (StringUtils.isEmpty(accountForm.getEmail()) || StringUtils.isEmpty(accountForm.getPassword())) {
            throw new AuthenticationServiceException("Email or Password not provided");
        }
        ApiAuthenticationToken token = new ApiAuthenticationToken(
                accountForm.getEmail(), accountForm.getPassword()
        );

        return this.getAuthenticationManager().authenticate(token);
    }
}
