package com.example.shopping_cart.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;

    public List<MyUser> findAll() {
        List<MyUser> myUsers = myUserRepository.findAll();
        if (myUsers.isEmpty()) {
            throw new EntityNotFoundException("No user(s) found");
        }
        return myUsers;
    }

    public MyUser findById(UUID id) {
        return myUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No user with " + id + " found"));
    }
}