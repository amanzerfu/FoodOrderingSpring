package et.com.amanuwel.DTO.RequestDto.ResponseDto;

import et.com.amanuwel.Entity.User;
import et.com.amanuwel.Utiliy.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
private User user;
private Status status;
}
