package et.com.amanuwel.repository;

import et.com.amanuwel.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UsersRepository extends JpaRepository<User,Long> {

    @Transactional
    @Modifying
    @Query("from User u where u.userPhone = :phone_no order by u.id")
    List<User> searchUserByPhoneNmber(@Param("phone_no") String phone);

}
