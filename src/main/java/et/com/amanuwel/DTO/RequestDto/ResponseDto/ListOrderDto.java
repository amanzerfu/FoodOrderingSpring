package et.com.amanuwel.DTO.RequestDto.ResponseDto;

import et.com.amanuwel.Entity.OrderFood;
import et.com.amanuwel.Utiliy.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListOrderDto {
private List<OrderFood> orderFoodList;
private Status ststus;
}
