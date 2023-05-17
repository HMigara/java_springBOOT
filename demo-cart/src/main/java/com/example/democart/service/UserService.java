package com.example.democart.service;

import com.example.democart.model.User;

public interface UserService {
    User findByUsername(String username);
}
