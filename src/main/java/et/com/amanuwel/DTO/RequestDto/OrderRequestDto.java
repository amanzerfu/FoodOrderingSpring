package et.com.amanuwel.DTO.RequestDto;

import et.com.amanuwel.Entity.Cart;
import et.com.amanuwel.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private Long id;
    private Cart cart;
    private User user;
}
