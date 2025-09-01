
# ESG 통합 대시보드 API

본 API는 TCFD, GRI, NetZero 영역별 진행률 및 배출량 정보를 제공하는 통합 ESG 대시보드를 위한 백엔드 API입니다.  
각 항목별 진행 상황을 사용자별로 조회할 수 있으며, 인증 기반으로 데이터를 반환합니다.

---

## 주요 기능

| 기능 구분 | 설명 |
|-----------|------|
| TCFD 진행률 조회 | 사용자의 TCFD 입력 현황을 기반으로 진행률(%) 계산 |
| GRI 진행률 조회 | GRI 항목 중 입력 완료 항목의 비율 계산 |
| NetZero 배출량 | 시뮬레이션 결과를 바탕으로 연도별 CO₂e 배출량 리스트 제공 |

---

## 인증 구조

- 모든 요청은 Gateway를 통해 전달되는 `X-MEMBER-ID` 헤더 값을 기반으로 사용자 식별을 수행합니다.
- 인증 실패 시 응답이 제한됩니다.

---

## API 처리 흐름도

```mermaid
flowchart TD
    A[Start] --> B[회원 인증 - X-MEMBER-ID 추출]

    %% 요청 유형 분기
    B --> C{요청 유형}

    %% TCFD 진행률
    C --> D1[TCFD 진행률 요청]
    D1 --> E1[dashboardService.getTcfdProgress]
    E1 --> F1[진행률 반환]
    F1 --> Z1((End))

    %% GRI 진행률
    C --> D2[GRI 진행률 요청]
    D2 --> E2[dashboardService.getGriProgress]
    E2 --> F2[진행률 반환]
    F2 --> Z2((End))

    %% NetZero 배출량
    C --> D3[NetZero 배출량 요청]
    D3 --> E3[dashboardService.getNetZeroEmissionProgress]
    E3 --> F3[배출량 리스트 반환]
    F3 --> Z3((End))

    %% 색상 스타일 정의
    classDef forest fill:#e6f4ea,stroke:#2e7d32,stroke-width:1.5px,color:#2e7d32;
    classDef terminal fill:#d0f0c0,stroke:#1b5e20,color:#1b5e20;

    %% 클래스 적용
    class A,Z1,Z2,Z3 terminal;
    class B,C,D1,D2,D3,E1,E2,E3,F1,F2,F3 forest;
````

---

## 기술 스택

* **Spring Boot + REST API**
* 사용자 인증 정보는 `X-MEMBER-ID` 헤더로 전달됨
* 서비스 계층에서 진행률 및 배출량 계산 수행
* 프론트엔드는 `Next.js + Recharts`로 시각화

---

## 개발 기여

* 진행률 계산 로직 설계 및 서비스 계층 구현
* TCFD, GRI, NetZero 데이터를 통합 조회하는 API 개발
* 사용자 단위 필터링 기반 ESG 대시보드 설계

---
