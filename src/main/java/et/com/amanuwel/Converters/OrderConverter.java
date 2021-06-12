package et.com.amanuwel.Converters;

import et.com.amanuwel.DTO.RequestDto.OrderRequestDto;
import et.com.amanuwel.Entity.OrderFood;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderConverter {
public OrderFood toOrderFoodConverter(OrderRequestDto orderRequestDto)
{
    String generatedString = RandomStringUtils.randomAlphanumeric(6).toLowerCase();
    OrderFood orderFoodEntity= new OrderFood();
    orderFoodEntity.setbooked_at(new Date());
    orderFoodEntity.setStatusid(true);
    String code="codetocancel";
    orderFoodEntity.setcancel_access_code(generatedString);
    orderFoodEntity.setUser(orderRequestDto.getUser());
    orderFoodEntity.setCart(orderRequestDto.getCart());

    return orderFoodEntity;
}
}
