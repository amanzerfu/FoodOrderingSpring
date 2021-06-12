package et.com.amanuwel.DTO.RequestDto.ResponseDto;

import et.com.amanuwel.Entity.Cart;
import et.com.amanuwel.Utiliy.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCartDto {
private List<Cart> cartList;
private Status status;
}
