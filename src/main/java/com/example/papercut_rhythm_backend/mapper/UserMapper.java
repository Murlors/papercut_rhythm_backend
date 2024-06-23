package com.example.papercut_rhythm_backend.mapper;

import com.example.papercut_rhythm_backend.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByUsername(String username);

    @Select("SELECT * FROM user WHERE username LIKE CONCAT('%',#{username},'%')")
    List<User> searchUserByUsername(String username);

    @Select("SELECT * FROM user")
    List<User> getAllUser();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(Integer id);

    @Insert("INSERT INTO user (username,password,email,role_id) VALUES (#{username},#{password},#{email},0)")
    Integer register(String username, String password, String email);

    @Update("UPDATE user SET avatar=#{avatar},introduction=#{introduction} WHERE id=#{id}")
    Integer updateUserInfo(String id, String avatar, String introduction);

    @Update("UPDATE user SET introduction=#{introduction} WHERE id=#{id}")
    Integer updateUserIntroduction(String id, String introduction);

    @Update("UPDATE user SET avatar=#{avatar} WHERE id=#{id}")
    Integer updateUserAvatar(String id, String avatar);

    @Update("UPDATE user SET state = 1  WHERE id=#{id}")
    Integer disableUser(String id);

    @Update("UPDATE user SET state = 0  WHERE id=#{id}")
    Integer enableUser(String id);

    @Update("UPDATE user SET role_id = #{roleId} WHERE id=#{userId}")
    Integer updateUserRole(String userId, String roleId);
}
