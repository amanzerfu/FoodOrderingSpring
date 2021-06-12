package et.com.amanuwel.DTO.RequestDto;

import et.com.amanuwel.Entity.Food;
import et.com.amanuwel.Utiliy.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFoods {
 private List<Food> foodList;
 Status status;
}
