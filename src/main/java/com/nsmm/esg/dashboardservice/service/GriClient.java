package com.nsmm.esg.dashboardservice.service;

import com.nsmm.esg.dashboardservice.dto.GriProgressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "gri-service")
public interface GriClient {

    @GetMapping("/api/v1/internal/gri/progress")
    GriProgressResponse getGriProgress(@RequestHeader("X-MEMBER-ID") Long memberId);
}