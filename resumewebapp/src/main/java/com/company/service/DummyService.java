package com.company.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    @PreAuthorize("hasRole('USER')")
    public void foo(){
        System.out.println("foo method in dummy");
    }
}
