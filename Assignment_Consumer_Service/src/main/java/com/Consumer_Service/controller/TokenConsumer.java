package com.Consumer_Service.controller;

import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
@FeignClient("token-service/auth")
public interface TokenConsumer {

    @GetMapping("/get-token/{id}")
    String createToken(@PathVariable("id") ObjectId id);

    @GetMapping("/get-userId-from-token/{token}")
    String getUserIdFromToken(@PathVariable("token") String token);

}
