package com.suunnytarwanni.BookMyShow.Service;

import com.suunnytarwanni.BookMyShow.Exception.InvalidPasswordException;
import com.suunnytarwanni.BookMyShow.Model.User;
import com.suunnytarwanni.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Isolation;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String email , String password) throws InvalidPasswordException {
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("Kindly enter the correct Email-Id");
        }


        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         if(encoder.matches(password ,user.getPassword())){
             return user;
         }

         throw new InvalidPasswordException("Invalid Password! Try Again");
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String email , String password) throws Exception {
        User savedUser = userRepository.findUserByEmail(email);
        if(savedUser != null){
            throw new Exception("User with same Email-Id already present");
        }

        User user = new User();
        user.setEmail(email);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        return userRepository.save(user);
    }

}
