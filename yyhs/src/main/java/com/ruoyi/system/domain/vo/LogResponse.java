package com.ruoyi.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogResponse {

    private Long id;

    private Long patientId;
    private Long patientName;

    private Long doctorId;
    private Long doctorName;

    private String deptId;
    private String deptName;

    private Integer status;
}
