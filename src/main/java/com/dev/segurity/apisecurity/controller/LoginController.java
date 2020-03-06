
package com.dev.segurity.apisecurity.controller;

import com.dev.segurity.apisecurity.dto.Credential;
import com.dev.segurity.apisecurity.dto.SessionInfo;
import com.dev.segurity.apisecurity.session.SessionManager;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public ResponseEntity<Object> login(HttpServletRequest request, @RequestBody Credential dto) {
        SessionInfo info = new SessionInfo();
        if (dto.getUsuario().equals("admin") && dto.getClave().equals("admin")) {
            info.setUsername(dto.getUsuario());
            info.setIp(request.getRemoteAddr());
            SessionManager.getInstance().add(info);
            return new ResponseEntity<>(info, HttpStatus.OK);
        }
        return new ResponseEntity<>(info, HttpStatus.UNAUTHORIZED);
    }
}
