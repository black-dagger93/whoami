package com.example.whoami;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/whoami")
public class WhoAmIController {

    @GetMapping
    WhoAmI getWhoAmI() {
        return new WhoAmI("John Doe");
    }

}


record WhoAmI(String name){}