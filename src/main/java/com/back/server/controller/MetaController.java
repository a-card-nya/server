package com.back.server.controller;

import com.back.server.dto.MetaResponseDto;
import com.back.server.service.MetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meta")
@RequiredArgsConstructor
public class MetaController {

    private final MetaService metaService;

    @GetMapping
    public ResponseEntity<MetaResponseDto> getMeta() {
        return ResponseEntity.ok(metaService.getAllMeta());
    }
}
