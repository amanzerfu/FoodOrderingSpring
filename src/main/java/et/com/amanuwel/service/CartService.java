package et.com.amanuwel.service;

import et.com.amanuwel.DTO.RequestDto.ResponseDto.CartDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListCartDto;
import et.com.amanuwel.Entity.Cart;
import et.com.amanuwel.Entity.Food;
import et.com.amanuwel.Entity.User;
import et.com.amanuwel.Utiliy.Status;
import et.com.amanuwel.Utiliy.StatusInit;
import et.com.amanuwel.repository.CartRepository;
import et.com.amanuwel.repository.FoodRepository;
import et.com.amanuwel.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {
@Autowired
    private CartRepository cartRepository;
@Autowired
        private UsersRepository usersRepository;
@Autowired
        private FoodRepository foodRepository;
@Autowired
    StatusInit statusInit;
public Status saveCart(Cart cart)
{
    User user=usersRepository.getById(cart.getUser().getId());
if(user!=null) {
    Food food=foodRepository.getById(cart.getFood().getId());
    if(food !=null) {
        cart.setUser(usersRepository.getById(cart.getUser().getId()));
        cart.setFood(foodRepository.getById(cart.getFood().getId()));
        cartRepository.save(cart);
        return statusInit.successful();
    }else
    {
        return statusInit.singleErrorInit("Oops..","Food not found with this id");
    }
}
else {
    return statusInit.singleErrorInit("Oops..","UserNotFound");
}
}
public ListCartDto listAllCart(){
    ListCartDto cartDto= new ListCartDto();
    if(!cartRepository.listAllCart().isEmpty()) {
        cartDto.setCartList(cartRepository.listAllCart());
        cartDto.setStatus(statusInit.successful());
        return cartDto;
    }else {
        return new ListCartDto(null,statusInit.singleErrorInit("Not found","Oops.. Empty cart"));
    }
}
public CartDto findCartById(Long id)
{
    CartDto cartDto= new CartDto();
    if(!cartRepository.findAll().isEmpty())
    {
        cartDto.setCart(cartRepository.getById(id));
        cartDto.setStatus(statusInit.successful());
        return cartDto;
    }else {
        return new CartDto(null,statusInit.singleErrorInit("Not found","Oops.. Empty cart"));
    }
}
}
