package com.finance.generic.UserDependent;

import com.finance.security.jwt.JwtUtils;
import com.finance.security.services.UserDetailsImpl;
import com.finance.security.services.UserDetailsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class UserDependentController<T, RES, REQ,
        S extends UserDependentService<T, RES ,REQ ,R ,ID>,
        R extends UserDependentRepository<T,ID>, ID>{

    private final S service;
    private final JwtUtils jwtUtils;
    private final UserDetailsServiceImpl userDetailsService;

    protected UserDependentController(S service, JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsService) {
        this.service = service;
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }


    @GetMapping
    public ResponseEntity<List<RES>> getAll(@CookieValue(value = "jwtToken",defaultValue = "null") String cookie) {
        if (cookie.equals("null")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String username = jwtUtils.getUserNameFromJwtToken(cookie);

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);


        return ResponseEntity.ok(service.findAll(userDetails.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RES> getById(@PathVariable ID id, @CookieValue(value = "jwtToken",defaultValue = "null") String cookie) {
        if (cookie.equals("null")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String username = jwtUtils.getUserNameFromJwtToken(cookie);

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

        String userId = userDetails.getId();
        Optional<RES> entity = service.findByIdDTO(userId, id);
        return entity.map(ResponseEntity::ok).orElseGet(()
                -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody REQ request, @CookieValue(value = "jwtToken",defaultValue = "null") String cookie) {
        if (cookie.equals("null")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String username = jwtUtils.getUserNameFromJwtToken(cookie);

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

        String userId = userDetails.getId();

        service.save(request, userId);
        return ResponseEntity.ok("Entidad Creada");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable ID id, @RequestBody REQ request,
                                         @CookieValue(value = "jwtToken",defaultValue = "null") String cookie) {
        if (cookie.equals("null")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String username = jwtUtils.getUserNameFromJwtToken(cookie);

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

        String userId = userDetails.getId();
        Boolean isUpdated = service.update(userId, id, request);
        if (isUpdated) {
            return ResponseEntity.ok("Entidad Actualizada");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable ID id,  @CookieValue(value = "jwtToken",defaultValue = "null") String cookie) {
        if (cookie.equals("null")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String username = jwtUtils.getUserNameFromJwtToken(cookie);

        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

        String userId = userDetails.getId();

        Boolean isDeleted = service.deleteById(userId, id);
        if (isDeleted) {
            return ResponseEntity.ok("Entidad Eliminada");
        }
        return ResponseEntity.notFound().build();
    }
}