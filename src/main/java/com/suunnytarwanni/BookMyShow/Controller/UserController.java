package com.suunnytarwanni.BookMyShow.Controller;


import com.suunnytarwanni.BookMyShow.Dto.UserLoginRequestDto;
import com.suunnytarwanni.BookMyShow.Dto.UserSignUpRequestDto;
import com.suunnytarwanni.BookMyShow.Dto.UserSignUpResponseDto;
import com.suunnytarwanni.BookMyShow.Model.User;
import com.suunnytarwanni.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookmyshow")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> signUp(@RequestBody UserSignUpRequestDto userSignUpRequestDto) throws Exception {
        if(userSignUpRequestDto.getEmail() == null){
            throw new Exception("Email-Id is mandatory!");
        }
        User user = userService.signUp(userSignUpRequestDto.getEmail(), userSignUpRequestDto.getPassword());
         UserSignUpResponseDto userSignUpResponseDto = new UserSignUpResponseDto();
         userSignUpResponseDto.setUserId(user.getId());

         return new ResponseEntity<>(userSignUpResponseDto , HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginRequestDto userLoginRequestDto){
        return ResponseEntity.ok(userService.login(userLoginRequestDto.getEmail() , userLoginRequestDto.getPassword()));
    }
}
