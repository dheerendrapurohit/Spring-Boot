package com.dheerendra.sms.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    private ResponseEntity<String> signUp(@RequestBody UserDto userDto){
        String result= userService.signUp(userDto);
        return result.equals("user registered successfully")?
                ResponseEntity.ok(result):ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signIn(userDto));
    }
}
