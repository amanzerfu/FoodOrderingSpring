package et.com.amanuwel.service;

import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListUsersDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.UserDto;
import et.com.amanuwel.Entity.User;
import et.com.amanuwel.Utiliy.Status;
import et.com.amanuwel.Utiliy.StatusInit;
import et.com.amanuwel.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    StatusInit statusInit;
    public Status createUser(User users)
    {
        usersRepository.save(users);
        return statusInit.successfullyAdded();
    }
    public ListUsersDto listAllUser()
    {
        ListUsersDto listOrderDto= new ListUsersDto();
        if(!usersRepository.findAll().isEmpty())
        {
            listOrderDto.setUsersList(usersRepository.findAll());
            listOrderDto.setStatus(statusInit.successful());
            return listOrderDto;
        }else
        {
            return new ListUsersDto(null,statusInit.singleErrorInit("Empty","record not found"));
        }
    }
    public UserDto findUserById(Long id)
    {
        UserDto orderDto= new UserDto();
        if(!usersRepository.findAll().isEmpty())
        {
            orderDto.setUser(usersRepository.getById(id));
            orderDto.setStatus(statusInit.successful());
            return orderDto;
        }else
        {
            return new UserDto(null, statusInit.singleErrorInit("Id not found","record Not found by this id"));
        }
    }
    public ListUsersDto searchUserByPhone(String phone){
        ListUsersDto listUsersDto= new ListUsersDto();
        List<User> userList= usersRepository.searchUserByPhoneNmber(phone);
        if(!userList.isEmpty())
        {
            listUsersDto.setUsersList(userList);
            listUsersDto.setStatus(statusInit.successful());
            return listUsersDto;
        }else {
            return new ListUsersDto(null,statusInit.singleErrorInit("Oops..","user not found using this phone "));
        }
    }
}
