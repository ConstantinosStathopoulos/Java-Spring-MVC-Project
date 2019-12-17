package gr.hua.dit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControler {

	@RequestMapping("/login")
	public String showLoginPage() {
	   return "login";
	}
}
