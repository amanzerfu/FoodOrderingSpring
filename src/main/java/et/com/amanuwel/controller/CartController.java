package et.com.amanuwel.controller;

import et.com.amanuwel.DTO.RequestDto.ResponseDto.CartDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListCartDto;
import et.com.amanuwel.Entity.Cart;
import et.com.amanuwel.Utiliy.Status;
import et.com.amanuwel.Utiliy.StatusInit;
import et.com.amanuwel.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;



@RestController
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    StatusInit statusInit;

    @PostMapping("/addCart")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Status saveCart(Cart cart) {
        cartService.saveCart(cart);
        return statusInit.successful();
    }

    @GetMapping("/ListAllCart")
    public ListCartDto listAllCart() {
        return cartService.listAllCart();
    }

    @GetMapping("/findCartById")
    public CartDto findCartById(@RequestParam Long id) {
        return cartService.findCartById(id);
    }


}