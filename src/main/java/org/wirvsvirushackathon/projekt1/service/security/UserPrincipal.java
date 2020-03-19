package org.wirvsvirushackathon.projekt1.service.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.wirvsvirushackathon.projekt1.persistence.model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@AllArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
public class UserPrincipal implements OAuth2User, UserDetails {

    @Getter
    private Long id;

    private String email;

    @Getter
    private String password;

    @Getter
    private Collection<? extends GrantedAuthority> authorities;

    @Getter
    @Setter
    private Map<String, Object> attributes;

    public static UserPrincipal of(User user) {
        return UserPrincipal.builder()
            .id(user.getId())
            .email(user.getEmail())
            .password(user.getPassword())
            .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
            .build();
    }

    public static UserPrincipal of(User user, Map<String, Object> attributes) {
        return UserPrincipal.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .attributes(attributes)
                .authorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")))
                .build();
    }

    @Override
    public String getName() {
        return String.valueOf(id);
    }

    @Override
    public String getUsername() { return email; }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

}
