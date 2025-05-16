package com.nsmm.esg.dashboardservice.service;

import com.nsmm.esg.dashboardservice.dto.TcfdProgressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final TcfdClient tcfdClient;

    public TcfdProgressResponse getTcfdProgress(Long memberId) {
        return tcfdClient.getTcfdProgress(memberId);
    }
}