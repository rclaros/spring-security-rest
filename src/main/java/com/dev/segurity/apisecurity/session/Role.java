package com.dev.segurity.apisecurity.session;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    private int id;
    private String code;
    private String name;
    private List<Privilege> privileges;

    @Override
    public String getAuthority() {

        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
