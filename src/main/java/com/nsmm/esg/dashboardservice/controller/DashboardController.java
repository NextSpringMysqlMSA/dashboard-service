package com.nsmm.esg.dashboardservice.controller;

import com.nsmm.esg.dashboardservice.dto.TcfdProgressResponse;
import com.nsmm.esg.dashboardservice.service.DashboardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/tcfd-progress")
    public ResponseEntity<TcfdProgressResponse> getTcfdProgress(HttpServletRequest request) {
        Long memberId = extractMemberId(request);
        return ResponseEntity.ok(dashboardService.getTcfdProgress(memberId));
    }

    private Long extractMemberId(HttpServletRequest request) {
        String memberIdHeader = request.getHeader("X-MEMBER-ID");
        if (memberIdHeader == null || memberIdHeader.isBlank()) {
            System.out.println("⚠️ X-MEMBER-ID 누락 → 기본값 1L 사용");
            return 1L;
        }
        return Long.parseLong(memberIdHeader);
    }
}