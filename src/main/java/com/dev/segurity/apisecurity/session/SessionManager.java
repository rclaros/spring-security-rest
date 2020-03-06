
package com.dev.segurity.apisecurity.session;

import com.dev.segurity.apisecurity.dto.SessionInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SessionManager {

    private static final SessionManager instance = new SessionManager();
    public static SessionManager getInstance() {
        return instance;
    }
    public void add(SessionInfo info) {
        Role r = new Role();
        r.setName("ROLE_ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(r);
        Collection<? extends GrantedAuthority> authorities = roles;
        Authentication nwahtu = new UsernamePasswordAuthenticationToken(info, info.getUsername(), authorities);
        SecurityContextHolder.getContextHolderStrategy().getContext().setAuthentication(nwahtu);
    }

    public SessionInfo get() {
        SessionInfo info = null;
        Authentication auth = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();
        if (auth != null) {
            info = (SessionInfo) auth.getPrincipal();
        }
        return info;
    }
}
