package com.dionysos.api.user.service;

import com.dionysos.api.user.dto.ResponseUserDto;
import com.dionysos.api.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMainService {

    private UserService userService;
    private JwtService jwtService;

    public ResponseUserDto getResponseUserDto() {
        String uid = jwtService.getUid();
        return getResponseUserDto(uid);
    }

    public ResponseUserDto getResponseUserDto(String uid) {
        User user = userService.getFromUid(uid);

        return ResponseUserDto
                .builder()
                .nickname(user.getNickname())
                .build();
    }

}