package et.com.amanuwel.DTO.RequestDto.ResponseDto;

import et.com.amanuwel.Entity.OrderFood;
import et.com.amanuwel.Utiliy.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
private OrderFood orderFood;
private Status status;
}
