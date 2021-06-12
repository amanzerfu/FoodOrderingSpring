package et.com.amanuwel.service;

import et.com.amanuwel.Converters.OrderConverter;
import et.com.amanuwel.DTO.RequestDto.OrderRequestDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListCartDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListOrderDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.OrderDto;
import et.com.amanuwel.Entity.OrderFood;
import et.com.amanuwel.Utiliy.Status;
import et.com.amanuwel.Utiliy.StatusInit;
import et.com.amanuwel.repository.CartRepository;
import et.com.amanuwel.repository.FoodRepository;
import et.com.amanuwel.repository.OrderFoodRepository;
import et.com.amanuwel.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFoodService {
    @Autowired
    OrderFoodRepository orderFoodRepository;
    @Autowired
    StatusInit statusInit;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderConverter orderConverter;
    public Status createOrder(OrderRequestDto orderFood){
        OrderFood orderFoodEntity= new OrderFood();
        if(usersRepository.getById(orderFood.getUser().getId()) !=///if the customer id registered
               null ) { // and cart is is registered validate the order
             if(cartRepository.getById(orderFood.getCart().getId()) !=null) {
                 orderFood.setUser(usersRepository.getById(orderFood.getUser().getId()));
                 orderFood.setCart(cartRepository.getById(orderFood.getCart().getId()));
                 orderFoodEntity=orderConverter.toOrderFoodConverter(orderFood);
                 orderFoodEntity.settotal_cart(1);
                 orderFoodEntity.settotal_price(orderFood.getCart().getFood().getPrice().floatValue());
                 orderFoodRepository.save(orderFoodEntity);
                 return statusInit.successful();
             }
             else{
                 return statusInit.singleErrorInit("Ooops..","food not found using this id");
             } }
        else {
            return statusInit.singleErrorInit("Error","Customer  not found");
        }
    }
    public ListOrderDto listAllOrder()///this method lists the orders if not empty
    {
        ListOrderDto listOrderDto= new ListOrderDto();
        if(!orderFoodRepository.findAll().isEmpty())
        {
            listOrderDto.setOrderFoodList(orderFoodRepository.findAll());
        listOrderDto.setStstus(statusInit.successful());
        return listOrderDto;
        }else
        {
            return new ListOrderDto(null,statusInit.singleErrorInit("Empty","record not found"));
        }
    }

    public OrderDto findFoodById(Long id)///this method find the order by id if not empty
    {
        OrderDto orderDto= new OrderDto();
        if(!orderFoodRepository.findAll().isEmpty())
        {
            orderDto.setOrderFood(orderFoodRepository.getById(id));
            orderDto.setStatus(statusInit.successful());
            return orderDto;
        }else
        {
            return new OrderDto(null, statusInit.singleErrorInit("Id not found","record Not found by this id"));
        }
    }
//    public ListCartDto getUsersCartByUserId(Long userId)
//    {
//        if(!cartRepository.listAllActiveCartOfUser(userId).isEmpty()) {
//            ListCartDto listCartDto = new ListCartDto();
//            listCartDto.setCartList(cartRepository.listAllActiveCartOfUser(userId));
//            listCartDto.setStatus(statusInit.successful());
//        return listCartDto;
//        }else {
//            return new ListCartDto(null,statusInit.singleErrorInit("Oops","id not found"));
//        }
//    }
}
