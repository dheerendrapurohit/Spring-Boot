package com.dheerendra.sms.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Auth2Controller {

    @GetMapping("/oauth-login")
    public String loginPage() {
        return """
                <h2>Login Page</h2>
                <a href="/oauth2/authorization/google">Continue with Google</a><br>
                <a href="/oauth2/authorization/microsoft">Continue with Microsoft</a>
                """;
    }

    @GetMapping("/oauth2-success")
    public String oauth2Success(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return "OAuth2 login failed. No user details received.";
        }

        String name = principal.getAttribute("name");
        String email = principal.getAttribute("email");

        return "Welcome, " + name + "! You are logged in as: " + email;
    }
}
