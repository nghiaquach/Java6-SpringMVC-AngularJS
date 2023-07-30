package com.fpoly.controller;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.entity.Account;
import com.fpoly.service.AccountService;

@CrossOrigin("*")
@RestController
public class UserRestController {
    @Autowired
    AccountService userService;

    @GetMapping("/api/account")
    public ResponseEntity<Optional<Account>> getAccount(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Account> account = userService.getAccount(username);
        if(account != null){
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }
}
