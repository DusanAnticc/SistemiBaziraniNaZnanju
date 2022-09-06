package sbnz.integracija.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sbnz.integracija.example.dto.UserDTO;
import sbnz.integracija.example.dto.UserTokenState;
import sbnz.integracija.example.model.User;
import sbnz.integracija.example.security.TokenUtils;
import sbnz.integracija.example.security.auth.JwtAuthenticationRequest;
import sbnz.integracija.example.support.UserToUserDTO;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    private final TokenUtils tokenUtils;
    private final AuthenticationManager authenticationManager;
    private final UserToUserDTO userToUserDTO;

    @Autowired
    public AuthenticationController(TokenUtils t, AuthenticationManager aM, UserToUserDTO userToUserDTO){
        this.tokenUtils = t;
        this.authenticationManager = aM;
        this.userToUserDTO = userToUserDTO;
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) {

        UsernamePasswordAuthenticationToken u = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                authenticationRequest.getPassword());
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(u);
        } catch(BadCredentialsException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername());
        int expiresIn = tokenUtils.getExpiredIn();
                
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

    @GetMapping("/getLoggedIn")
    public ResponseEntity<UserDTO> getLoggedInUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        User user = (User) authentication.getPrincipal();
        if (user == null)
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);

        UserDTO dto = userToUserDTO.convert(user);

        return new ResponseEntity<>(dto,  HttpStatus.OK);

    }

    @GetMapping(value = "/logOut", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> logoutUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)){
            SecurityContextHolder.clearContext();

            return new ResponseEntity<>("You successfully logged out!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User is not authenticated!", HttpStatus.BAD_REQUEST);
        }

    }
}