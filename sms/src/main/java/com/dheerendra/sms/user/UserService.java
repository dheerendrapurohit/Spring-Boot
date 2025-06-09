package com.dheerendra.sms.user;

public interface UserService {

    String signUp(UserDto userDto);

    String signIn(UserDto userDto);
}
