package com.Admin_Service.controller;

import com.Admin_Service.exceptionHandling.BadRequestException;
import com.Admin_Service.exceptionHandling.UserException;
import com.Admin_Service.model.PayloadValidation;
import com.Admin_Service.model.User;
import com.Admin_Service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody User payload) throws BadRequestException {

        if(!PayloadValidation.createdPayloadIdValidation(payload)) throw new BadRequestException("PAYLOAD MALFORMED. OBJECT ID MUST NOT BE DEFINED !!!");

        if(!service.getUserByUserName(payload.getUsername()).isEmpty()) throw new BadRequestException("User with this USERNAME is already present!!!");

        return service.signupService(payload);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody Map<String, Object> map) throws UserException, BadRequestException {

        if(!PayloadValidation.createdPayloadUsernameField(map)) throw new BadRequestException("PAYLOAD MALFORMED. Username Must be Provided at Login !!!");

        if(service.getUserByUserName(map.get("username").toString()).isEmpty()) throw new UserException("User with this username NOT FOUND");

        return service.loginService(map.get("username").toString(), map.get("password").toString());
    }

    @RequestMapping(value = "/get-users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return service.getUsers();
    }

}
