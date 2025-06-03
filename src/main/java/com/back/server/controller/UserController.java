package com.back.server.controller;

import com.back.server.dto.UserRequestDto;
import com.back.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Map<String, Long>> createUser(@RequestBody UserRequestDto dto) {
        Long userId = userService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("user_id", userId));
    }
}

