package ro.fasttrack.tema12exerc1.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController
{
    @GetMapping("whoami")
    SecurityContext whoami() { return SecurityContextHolder.getContext(); }
}
