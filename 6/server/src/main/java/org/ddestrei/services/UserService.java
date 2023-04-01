package org.ddestrei.services;

import lombok.RequiredArgsConstructor;
import org.ddestrei.entites.User;
import org.ddestrei.repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public String save(User user){
        Optional<User> userCheck = repository.findByEmail(user.getEmail());
        if(userCheck.isPresent()){
            throw new IllegalArgumentException("User is already in DB with this "+user.getEmail()+" email");
        }
        else {
            repository.save(user);
        }
        return "";
    }

    public User findByEmail(String email){
        Optional<User> user = repository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        else {
            throw new IllegalArgumentException("User not found with this "+ email +" email");
        }
    }
}
