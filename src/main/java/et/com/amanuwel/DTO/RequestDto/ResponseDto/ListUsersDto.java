package et.com.amanuwel.DTO.RequestDto.ResponseDto;

import et.com.amanuwel.Entity.User;
import et.com.amanuwel.Utiliy.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListUsersDto {
private List<User> usersList;
private Status status;
}
