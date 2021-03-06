package com.neuedu.dao;

import com.neuedu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    int insert(User user);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table neuedu_user
     *
     * @mbg.generated
     */
    List<User> selectAll();

    int checkUsernameExist(@Param("username") String username);

    int checkEmailExist(@Param("email") String email);

    User checkByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    String forgetPassword_get_question(@Param("username") String username);

    int forgetPassword_check_answer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    int forgetPassword_reset_password(@Param("username") String username, @Param("password") String passwordNew);

    int updateUserByActivate(@Param("user") User user);
}