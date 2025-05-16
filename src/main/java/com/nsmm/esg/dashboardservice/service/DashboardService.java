package com.nsmm.esg.dashboardservice.service;

import com.nsmm.esg.dashboardservice.dto.GriProgressResponse;
import com.nsmm.esg.dashboardservice.dto.NetZeroEmissionResponse;
import com.nsmm.esg.dashboardservice.dto.TcfdProgressResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final TcfdClient tcfdClient;
    private final GriClient griClient;

    public TcfdProgressResponse getTcfdProgress(Long memberId) {
        return tcfdClient.getTcfdProgress(memberId);
    }

    public GriProgressResponse getGriProgress(Long memberId) {
        return griClient.getGriProgress(memberId);
    }

    public List<NetZeroEmissionResponse> getNetZeroEmissionProgress(Long memberId) {
        return tcfdClient.getNetZeroProgress(memberId);
    }


}