package id.co.astrafinancial.oauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/oauth/profile")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<Principal> getPrincipal(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
}
