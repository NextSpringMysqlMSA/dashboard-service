package com.nsmm.esg.dashboardservice.service;

import com.nsmm.esg.dashboardservice.dto.NetZeroEmissionResponse;
import com.nsmm.esg.dashboardservice.dto.TcfdProgressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**
 * 🔌 TCFD 마이크로서비스의 내부 API를 호출하기 위한 FeignClient 인터페이스
 * - Feign은 REST API 호출을 추상화하여 인터페이스 메서드로 쉽게 호출할 수 있게 해줌
 * - Gateway를 통해 lb://tcfd-service 주소로 라우팅됨 (Eureka 연동)
 */
@FeignClient(name = "tcfd-service")
public interface TcfdClient {

    /**
     * ✅ TCFD 전체 작성 현황(progress) API 호출
     * - 내부 경로: /api/v1/internal/tcfd/progress
     * - memberId는 Gateway에서 JWT 디코딩 후 X-MEMBER-ID 헤더로 전달됨
     */
    @GetMapping("/api/v1/internal/tcfd/progress")
    TcfdProgressResponse getTcfdProgress(@RequestHeader("X-MEMBER-ID") Long memberId);

    /**
     * ✅ Net Zero 목표 작성 현황(progress) API 호출
     * - 내부 경로: /api/v1/internal/tcfd/progress/netzero
     * - Net Zero 항목만 따로 분리하여 완료율 반환
     */
    @GetMapping("/api/v1/internal/tcfd/progress/netzero")
    List<NetZeroEmissionResponse> getNetZeroProgress(@RequestHeader("X-MEMBER-ID") Long memberId);
}
