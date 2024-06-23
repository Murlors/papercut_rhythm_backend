package com.example.papercut_rhythm_backend.service;

import com.example.papercut_rhythm_backend.bean.R;
import com.example.papercut_rhythm_backend.bean.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface UserService {
    R<Map<String, String>> login(String username, String password, HttpSession session);

    R<String> register(String username, String password, String email, String vCode);

    R<String> sendMail(String email, String subject, String body);

    User getUserById(String id);

    R<User> updateUserInfo(String id, String avatar, String introduction);

    R<String> disableUser(String id);

    R<String> updateUserRole(String userId, String roleId);

    R<Map<String, Object>> keepSession(HttpSession session);

    R<List<User>> getUserList(String username);

    R<String> enableUser(String id);

    R<String> logout(HttpSession session);
}
