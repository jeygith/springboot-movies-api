package com.githinit.springboot.moviesapi.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    DefaultTokenServices tokenServices;

    @PostMapping("/tokens/revoke/{tokenId:.*}")
    public String revokeToken(@PathVariable String tokenId) {
        tokenServices.revokeToken(tokenId);
        return tokenId;
    }


    @PostMapping("/login")
    public String login() {
        return "login";
    }


}
