package com.wallet.auth.service;

import com.wallet.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
