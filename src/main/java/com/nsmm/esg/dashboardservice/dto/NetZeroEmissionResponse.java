package com.nsmm.esg.dashboardservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NetZeroEmissionResponse {
    private int year;
    private double emission;
}
