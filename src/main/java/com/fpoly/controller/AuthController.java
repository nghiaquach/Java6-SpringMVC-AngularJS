package com.fpoly.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.service.AccountService;

@Controller
public class AuthController {

	@Autowired
	AccountService accountService;

	@RequestMapping("/auth/login/form")
	public String form(){
		return "login";
	}
	
	@RequestMapping("/auth/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         List<String> authList = new ArrayList<>();
         // Check if the user is authenticated
         if (authentication != null && authentication.isAuthenticated()) {
            List<String> roleNames = accountService.getRolesByUsername(authentication.getName());

            for (String roleName : roleNames) {
               authList.add("ROLE_" + roleName);
            }
         }

		if(authList.contains("ROLE_ADMIN")){
			return "redirect:/auth/index";
		} 
		else{
			return"redirect:/home/index";
		}
		
	}
	
	@RequestMapping("/auth/login/error")
	public String error(Model model){
		model.addAttribute("message", "Sai thông tin đăng nhập!");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/logoff/success")
	public String logoff(Model model){
		model.addAttribute("message", "Đăng xuất thành công!");
		return "redirect:/auth/login/form";
	}

	@RequestMapping("/auth/access/denied")
	public String denied(Model model){
		model.addAttribute("message", "Bạn không có quyền truy xuất!");
		return "login";
	}
	
	/*
	 * OAuth2
	 */
	
	// @Autowired
	// UserService userService;
	
	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2){
		//userService.loginFromOAuth2(oauth2);
		return "forward:/auth/login/success";
	}
}