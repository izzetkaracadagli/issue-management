package com.karacadaglii.issuemanagement.Entity.service;

import com.karacadaglii.issuemanagement.Entity.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUserName(String userName);
}
