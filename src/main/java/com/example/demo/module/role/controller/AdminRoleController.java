package com.example.demo.module.role.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequiredArgsConstructor
public class AdminRoleController {
    //admin/roles
    //Admin에 의한 role 종류 관리
    @GetMapping("/admin/roles")
    public String getRolesByAdmin() {
        return "admin/role/list";
    }

    //view role
    @GetMapping("/admin/role/{id}")
    public String getRoleByAdmin() {
        return "admin/role/view";
    }

    //register role
    @GetMapping("/admin/role/new")
    public String createRoleFormByAdmin() {
        return "admin/role/new";
    }

    @PostMapping("/admin/role/")
    public String createRoleByAdmin() {
        return "redirect:/admin/roles";
    }

    //edit account
    @GetMapping("/admin/role/{id}/edit")
    public String getRoleForEditByAdmin() {

        return "admin/role/edit";
    }

    //edit account
    @PutMapping("/admin/role/{id}")
    public String editRoleByAdmin() {
        return "redirect:/admin/roles";
    }

    //delete account
    @DeleteMapping("/admin/role/{id}")
    public String deleteRoleByAdmin() {
        return "redirect:/admin/roles";
    }
}
