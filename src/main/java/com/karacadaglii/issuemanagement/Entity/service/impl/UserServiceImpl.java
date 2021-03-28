package com.karacadaglii.issuemanagement.Entity.service.impl;

import com.karacadaglii.issuemanagement.Entity.Entity.User;
import com.karacadaglii.issuemanagement.Entity.repository.UserRepository;
import com.karacadaglii.issuemanagement.Entity.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service // Singlrton bi instabce yaratır.
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if(user.getEmail() == null){
            throw new IllegalArgumentException("User email cannot be null.");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }
}
