package com.wallet.auth.service;

import com.wallet.auth.model.Role;
import com.wallet.auth.model.User;
import com.wallet.auth.repository.RoleRepository;
import com.wallet.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role1 = new Role();
        role1.setName("ROLE_USER");
        Role role2 = new Role();
        role2.setName("ROLE_ADMIN");
        Set<Role> r = new HashSet<>();
        r.add(role1);
        r.add(role2);
        user.setRoles(r);
        user.setBalance(new Long(0));
        roleRepository.save(role1);
        roleRepository.save(role2);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
