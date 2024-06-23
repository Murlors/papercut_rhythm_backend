package com.example.papercut_rhythm_backend.mapper;

import com.example.papercut_rhythm_backend.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUserByUsername(String username);

    List<User> searchUserByUsername(String username);

    List<User> getAllUser();

    User getUserById(Integer id);

    Integer register(String username, String password, String email);

    Integer updateUserInfo(String id, String avatar, String introduction);

    Integer updateUserIntroduction(String id, String introduction);

    Integer updateUserAvatar(String id, String avatar);

    Integer disableUser(String id);

    Integer enableUser(String id);

    Integer updateUserRole(String userId, String roleId);
}
