package com.nsmm.esg.dashboardservice.service;

import com.nsmm.esg.dashboardservice.dto.TcfdProgressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "tcfd-service", url = "http://localhost:8080")
public interface TcfdClient {

    @GetMapping("/api/v1/internal/tcfd/progress")
    TcfdProgressResponse getTcfdProgress(@RequestHeader("X-MEMBER-ID") Long memberId);
}
