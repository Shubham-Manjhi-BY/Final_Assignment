package com.Consumer_Service.controller;

import com.Consumer_Service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/admin-service/user")
@FeignClient("admin-service/user")
public interface AdminConsumer {

    @PostMapping("/signup")
    String signup(@RequestBody User user);

    @PostMapping("/login")
    String login(@RequestBody Map<String, Object> map);


    @GetMapping("/get-users")
    List<User> getUsers();


}
