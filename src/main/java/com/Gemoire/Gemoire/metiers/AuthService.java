package com.Gemoire.Gemoire.metiers;

import com.Gemoire.Gemoire.dao.AdminDao;
import com.Gemoire.Gemoire.entity.Admin;
import com.Gemoire.Gemoire.helpers.LoginRequest;
import com.Gemoire.Gemoire.helpers.SignupRequest;
import com.Gemoire.Gemoire.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private AdminDao adminDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    public void signup(SignupRequest signupRequest) {
        Admin admin = new Admin();
        admin.setEmail(signupRequest.getEmail());
        admin.setUsername(signupRequest.getUsername());
        admin.setPassword(encodePassword(signupRequest.getPassword()));
        adminDao.save(admin);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        System.out.println("Username :"+loginRequest.getUsername()+" token :"+authenticationToken);
        return new AuthenticationResponse(authenticationToken, loginRequest.getUsername());
    }

    public Optional<User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
}
