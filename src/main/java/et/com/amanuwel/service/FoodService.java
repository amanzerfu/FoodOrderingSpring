package et.com.amanuwel.service;

import et.com.amanuwel.DTO.RequestDto.ResponseDto.FoodDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListFoodDto;
import et.com.amanuwel.DTO.RequestDto.ResponseDto.ListUsersDto;
import et.com.amanuwel.Entity.Food;
import et.com.amanuwel.Utiliy.Status;
import et.com.amanuwel.Utiliy.StatusInit;
import et.com.amanuwel.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
@Autowired
    FoodRepository foodRepository;
@Autowired
    StatusInit statusInit;
public Status addFood(Food food){
foodRepository.save(food);
return statusInit.successful();
}
    public ListFoodDto listAllFood(){
        ListFoodDto cartDto= new ListFoodDto();
        if(!foodRepository.findAll().isEmpty()) {
            cartDto.setFoodList(foodRepository.findAll());
            cartDto.setStatus(statusInit.successful());
            return cartDto;
        }else {
            return new ListFoodDto(null,statusInit.singleErrorInit("Not found","Oops.. Empty Food"));
        }
    }
    public FoodDto findFoodById(Long id)
    {
        FoodDto cartDto= new FoodDto();
        if(!foodRepository.findAll().isEmpty())
        {
            cartDto.setFood(foodRepository.getById(id));
            cartDto.setStatus(statusInit.successful());
            return cartDto;
        }else {
            return new FoodDto(null,statusInit.singleErrorInit("Not found","Oops.. Empty cart"));
        }
    }
    public ListFoodDto searchFoodByFoodName(String food_name)
    {
        ListFoodDto listFoodDto= new ListFoodDto();
        List<Food> foodList= foodRepository.searchFoodByFoodName(food_name);
        if(!foodList.isEmpty())
        {
            listFoodDto.setFoodList(foodList);
            listFoodDto.setStatus(statusInit.successful());
            return listFoodDto;
        }
        else
        {
            return new ListFoodDto(null,statusInit.singleErrorInit("Not found", "No food found using this name"));
        }
    }
}
