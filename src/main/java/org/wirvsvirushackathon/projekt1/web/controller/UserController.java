package org.wirvsvirushackathon.projekt1.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wirvsvirushackathon.projekt1.exception.ResourceNotFoundException;
import org.wirvsvirushackathon.projekt1.persistence.model.User;
import org.wirvsvirushackathon.projekt1.persistence.repository.UserRepository;
import org.wirvsvirushackathon.projekt1.service.security.CurrentUser;
import org.wirvsvirushackathon.projekt1.service.security.UserPrincipal;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}