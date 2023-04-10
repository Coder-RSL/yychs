package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 tbl_schedule
 * 
 * @author ruoyi
 * @date 2023-04-02
 */
public class TblSchedule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}")
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
    @Excel(name = "日", readConverterExp = "$column.readConverterExp()")
    private Integer day;

    /** 周 */
    @Excel(name = "周")
    private Integer week;

    /** 月 */
    @Excel(name = "月")
    private Integer month;

    /** $column.columnComment */
    @Excel(name = "年", readConverterExp = "$column.readConverterExp()")
    private Integer year;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDoctorId(Long doctorId) 
    {
        this.doctorId = doctorId;
    }

    public Long getDoctorId() 
    {
        return doctorId;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setDay(Integer day) 
    {
        this.day = day;
    }

    public Integer getDay() 
    {
        return day;
    }
    public void setWeek(Integer week) 
    {
        this.week = week;
    }

    public Integer getWeek() 
    {
        return week;
    }
    public void setMonth(Integer month) 
    {
        this.month = month;
    }

    public Integer getMonth() 
    {
        return month;
    }
    public void setYear(Integer year) 
    {
        this.year = year;
    }

    public Integer getYear() 
    {
        return year;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("doctorId", getDoctorId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("parentId", getParentId())
            .append("day", getDay())
            .append("week", getWeek())
            .append("month", getMonth())
            .append("year", getYear())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status",getStatus())
            .toString();
    }
}
