package et.com.amanuwel.repository;

import et.com.amanuwel.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface CartRepository extends JpaRepository<Cart,Long> {
    @Transactional
    @Modifying
    @Query("from Cart c left join fetch c.food cf left join fetch c.user cu order by c.id")
    List<Cart> listAllCart();
}

