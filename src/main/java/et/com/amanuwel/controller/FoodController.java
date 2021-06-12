package et.com.amanuwel.controller;

import et.com.amanuwel.DTO.RequestDto.ResponseDto.FoodDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListFoodDto;
import et.com.amanuwel.Entity.Food;
import et.com.amanuwel.Utiliy.Status;
import et.com.amanuwel.Utiliy.StatusInit;
import et.com.amanuwel.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodController {
    @Autowired
    FoodService foodService;
    @Autowired
    StatusInit statusInit;
    @PostMapping("/addFood")
    public Status saveFood(@RequestBody Food cart)
    {
        foodService.addFood(cart);
        return statusInit.successful();
    }
    @GetMapping("/ListAllFood")
    public ListFoodDto listAllFood()
    {
        return foodService.listAllFood();
    }
    @GetMapping("/findFoodById")
    public FoodDto findFoodById(@RequestParam Long id)
    {
        return foodService.findFoodById(id);
    }
    @GetMapping("/searchFoodByName")
    public ListFoodDto searchFoodByFoodName(@RequestParam String food_name)
    {
        return foodService.searchFoodByFoodName(food_name);
    }
}