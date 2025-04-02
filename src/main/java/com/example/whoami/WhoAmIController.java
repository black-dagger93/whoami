package com.example.whoami;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/whoami")
public class WhoAmIController {

    private final UpsFeignClient upsFeignClient;

    public WhoAmIController(UpsFeignClient upsFeignClient) {
        this.upsFeignClient = upsFeignClient;
    }

    @GetMapping
    WhoAmI getWhoAmI() {
        return new WhoAmI("JohnDoe", 18, Gender.MALE);
    }

    @GetMapping("/ups-account/{name}")
    UserProfile getUpsAccountName(@PathVariable String name) {
        return upsFeignClient.getAllUsers().stream().filter(
                s -> Objects.equals(s.name(), name)
        ).findFirst().orElseThrow();
    }
}

record WhoAmI(String name, int age, Gender gender){}

enum Gender {
    MALE, FEMALE
}

record UserProfile(String name){}