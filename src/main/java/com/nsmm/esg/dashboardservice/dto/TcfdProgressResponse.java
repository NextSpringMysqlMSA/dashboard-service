package com.nsmm.esg.dashboardservice.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TcfdProgressResponse {
    private int completedCount;
    private int inCompletedCount;
    private int totalCount;
    private int completedRate;
}
