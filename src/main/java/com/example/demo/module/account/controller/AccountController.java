package com.example.demo.module.account.controller;

import com.example.demo.module.account.domain.AccountRegisterDtoValidator;
import com.example.demo.module.account.domain.dto.AccountAppDto;
import com.example.demo.module.account.domain.dto.AccountRegisterDto;
import com.example.demo.module.account.domain.dto.AccountRegisteredDto;
import com.example.demo.module.account.domain.dto.AccountRoleDto;
import com.example.demo.module.account.domain.entity.Account;
import com.example.demo.module.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {
    private final AccountService accountService;

    @PostMapping(value = "/register")
    public AccountRegisteredDto createUser(@RequestBody AccountRegisterDto accountForm) {
        log.info("register api");
        AccountRegisteredDto result = accountService.registerNewAccount(accountForm);

        return result;
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception, Model model){
        model.addAttribute("error",error);
        model.addAttribute("exception",exception);
        return "user/login";
    }

    @PostMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "logout";
    }

    @GetMapping(value = "/account")
    public AccountRoleDto getUserWithRole(@RequestBody AccountRoleDto data) {
        log.info("getUserWithRole api");
        AccountRoleDto result = accountService.getAccountWithRoleByEmail(data.getEmail());
        log.info("result : " + result);
        return result;
    }

    @PostMapping(value = "account/one/application")
    public AccountAppDto getUserWithRole(@RequestBody AccountAppDto data) {
        log.info("get one with applicaiton api");
        AccountAppDto result = accountService.getAccountWithApp(data);
        log.info("result : " + result);
        return result;
    }
}
