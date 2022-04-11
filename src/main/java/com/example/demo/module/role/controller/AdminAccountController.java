package com.example.demo.module.role.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequiredArgsConstructor
public class AdminAccountController {
    //admin/accounts
    //Admin에 의한 Account 관리
    //Account Role 권한 조정, 탈퇴, Manager 승인
    //get admin/accounts
    @GetMapping("/admin/accounts")
    public String getAccountsByAdmin() {

        return "admin/account/list";
    }

    //view account
    @GetMapping("/admin/account/{id}")
    public String getAccoutByAdmin() {
        return "admin/account/view";
    }

    //edit account
    @GetMapping("/admin/account/{id}/edit")
    public String getAccountForEditByAdmin() {

        return "admin/account/edit";
    }

    //edit account
    @PutMapping("/admin/account/{id}")
    public String editAccountByAdmin() {
        return "redirect:/admin/accounts";
    }

    //delete account
    @DeleteMapping("/admin/account/{id}")
    public String deleteAccountByAdmin() {
        return "redirect:/admin/accounts";
    }


}
