package et.com.amanuwel.controller;

import et.com.amanuwel.DTO.RequestDto.OrderRequestDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListCartDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListOrderDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.OrderDto;
import et.com.amanuwel.Utiliy.Status;
import et.com.amanuwel.Utiliy.StatusInit;
import et.com.amanuwel.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import java.awt.*;


@RestController
public class OrderController {
@Autowired
    OrderFoodService orderFoodService;
    @Autowired
    StatusInit statusInit;

    @PostMapping("/save_order")
    public Status saveOrder(@RequestBody OrderRequestDto orderFood)
    {
        return orderFoodService.createOrder(orderFood);
    }
    @GetMapping("/ListAllOrder")
    public ListOrderDto listAllOrder()
    {
        return orderFoodService.listAllOrder();
    }
//    @PostMapping("/ListAllCartByUserId")
//    public ListCartDto listAllCartByUserId(@RequestParam Long id)
//    {
//        return orderFoodService.getUsersCartByUserId(id);
//    }

    @GetMapping("/findOrderById")
    public OrderDto findOrderById(@RequestParam Long id)
    {
        return orderFoodService.findFoodById(id);
    }


}
