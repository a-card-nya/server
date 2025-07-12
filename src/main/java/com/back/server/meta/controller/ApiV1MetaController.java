package com.back.server.common.controller;

import com.back.server.common.domain.Region;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/meta")
@RequiredArgsConstructor
@Tag(name = "ApiV1MetaController", description = "메타데이터 관련 API")
public class ApiV1MetaController {

    @GetMapping("/regions")
    public ResponseEntity<List<MetaOption>> getRegions() {
        List<MetaOption> regions = Arrays.stream(Region.values())
                .map(r -> new MetaOption(r.name(), r.getLabel()))
                .toList();
        return ResponseEntity.ok(regions);
    }
}
