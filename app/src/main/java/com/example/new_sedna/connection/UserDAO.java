package com.example.new_sedna.connection;

import com.example.new_sedna.user.UserDto;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    // Define a static collection to store the user data
    private static final Map<String, UserDto> users = new HashMap<>();

    // 테스트를 위한 유저 생성
    static {
        users.put("012345678", new UserDto("012345678", "1234", "Chance"));
        users.put("987654321", new UserDto("987654321", "5678", "DoWon"));
    }

    // Get a user by ID
    public static UserDto getUser(String id) {
        return users.get(id);
    }
}
