package com.ruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

@Data
public class ScheduleResponse  {
    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long doctorId;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String endTime;

    /** 模板名称
     */
    @Excel(name = "模板名称 ")
    private Long parentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer day;

    /** 周 */
    @Excel(name = "周")
    private Integer week;

    /** 月 */
    @Excel(name = "月")
    private Integer month;

    private Integer status;
    private String statusName;
    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer year;

    private String doctorName;

    private String schduleFormName;
}
