package com.dheerendra.sms.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dheerendra.sms.user.UserDto;


import java.util.Optional;
import java.lang.Object;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String signUp(UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()).isPresent()) {
            return "username is already exist";
        }

        User newUser = new User();
        newUser.setUsername(userDto.getUsername());


        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        System.out.println("Encoded Password: " + encodedPassword);
        newUser.setPassword(encodedPassword);

        userRepository.save(newUser);
        return "user registered successfully";
    }

    @Override
    public String signIn(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
                return "Login successful!";
            } else {
                return "Invalid password!";
            }
        } else {
            return "Username not found!";
        }
    }
    }


