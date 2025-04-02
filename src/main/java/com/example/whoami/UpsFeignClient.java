package com.example.whoami;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "ups-feign-client", url = "${client.ups.baseUrl}")
public interface UpsFeignClient {

    @GetMapping("/api/users")
    List<UserProfile> getAllUsers();
}