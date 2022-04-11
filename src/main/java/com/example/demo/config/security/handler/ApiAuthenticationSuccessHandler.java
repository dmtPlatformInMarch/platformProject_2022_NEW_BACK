package com.example.demo.config.security.handler;

import com.example.demo.module.account.domain.dto.AccountAuthDto;
import com.example.demo.module.account.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class ApiAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final ObjectMapper mapper = new ObjectMapper();
    private final AccountRepository accountRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        if(authentication == null) log.info("auth is null");
        if(authentication.getPrincipal() == null) log.info("principal is null");
        log.info("principal");
        log.info(authentication.getPrincipal().toString());

        AccountAuthDto account = accountRepository.findByEmailWhenLogin(authentication.getPrincipal().toString());
        account.setToken(UUID.randomUUID().toString());
        log.info("findByEmailWhenLogin", account);

        response.setStatus(HttpStatus.OK.value());
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        mapper.writeValue(response.getWriter(), account);
    }
}
