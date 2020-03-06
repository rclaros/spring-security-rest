package com.dev.segurity.apisecurity.controller;

import com.dev.segurity.apisecurity.session.SessionManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SessionController {
    @RequestMapping(path = "/info")
    public ResponseEntity<Object> login() {
        return new ResponseEntity<>(SessionManager.getInstance().get(), HttpStatus.OK);
    }
}
