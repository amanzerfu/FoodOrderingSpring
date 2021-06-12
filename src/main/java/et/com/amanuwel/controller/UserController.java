package et.com.amanuwel.controller;

import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListUsersDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.UserDto;
import et.com.amanuwel.Entity.User;
import et.com.amanuwel.Utiliy.Status;
import et.com.amanuwel.Utiliy.StatusInit;
import et.com.amanuwel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    StatusInit statusInit;
    @PostMapping("/addUser")
    public Status saveUser(@RequestBody User users)
    {
        userService.createUser(users);
        return statusInit.successful();
    }
    @GetMapping("/ListAllUser")
    public ListUsersDto listAllUser()
    {
        return userService.listAllUser();
    }

    @GetMapping("/findUserById")
    public UserDto findUserById(@RequestParam Long id)
    {
        return userService.findUserById(id);
    }
    @GetMapping("/searchUserByPhone")
    public ListUsersDto searchUserByPhone(@RequestParam String phone_num)
    {
        return userService.searchUserByPhone(phone_num);
    }
}
