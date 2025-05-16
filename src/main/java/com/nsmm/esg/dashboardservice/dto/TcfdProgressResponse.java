package com.nsmm.esg.dashboardservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TcfdProgressResponse {
    private int completedCount;
    private int inCompletedCount;
    private int totalCount;
    private int completedRate;
}
