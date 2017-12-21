package com.integritas.cellphonebay.controller;


import com.integritas.cellphonebay.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.integritas.cellphonebay.util.PathUtil.*;

@RestController
@RequestMapping(value = BASE_URI + USER )
class UserController {


    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private com.integritas.cellphonebay.service.UserService service;


    @RequestMapping(value = ALL, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> findAllUsers(final HttpServletRequest request) {

        List<User> users = service.findAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }

}