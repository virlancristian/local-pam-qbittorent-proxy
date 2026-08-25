package net.varlikip.local.pam.qbittorent.proxy.controller.auth;

import net.varlikip.local.pam.qbittorent.proxy.exception.auth.AuthenticationException;
import net.varlikip.local.pam.qbittorent.proxy.model.auth.AuthenticationRequest;
import net.varlikip.local.pam.qbittorent.proxy.model.auth.AuthenticationResponse;
import net.varlikip.local.pam.qbittorent.proxy.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private static final String LOGIN_PAGE_FILENAME = "index";

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/")
    public String getLoginPage(Model model) {
        model.addAttribute("credentials", new AuthenticationRequest());
        return LOGIN_PAGE_FILENAME;
    }

    @PostMapping("/")
    public String login(@ModelAttribute AuthenticationRequest credentials, Model model) {
        try {
            AuthenticationResponse response = this.authenticationService.login(credentials);
        } catch (AuthenticationException error) {
            model.addAttribute("errorMessage", error.getMessage());
        }

        return "redirect://google.com";
    }
}
