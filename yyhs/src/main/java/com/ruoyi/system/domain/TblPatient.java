package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 tbl_patient
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public class TblPatient extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** 0为禁用、1为可以 */
    @Excel(name = "0为禁用、1为可以")
    private Long status;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer age;

    /** 0男1女 */
    @Excel(name = "0男1女")
    private Integer sex;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String identityCard;

    /** 违约次数 */
    @Excel(name = "违约次数")
    private Integer defaultTime;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long craeteBy;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setIdentityCard(String identityCard) 
    {
        this.identityCard = identityCard;
    }

    public String getIdentityCard() 
    {
        return identityCard;
    }
    public void setDefaultTime(Integer defaultTime) 
    {
        this.defaultTime = defaultTime;
    }

    public Integer getDefaultTime() 
    {
        return defaultTime;
    }
    public void setCraeteBy(Long craeteBy) 
    {
        this.craeteBy = craeteBy;
    }

    public Long getCraeteBy() 
    {
        return craeteBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("status", getStatus())
            .append("age", getAge())
            .append("sex", getSex())
            .append("identityCard", getIdentityCard())
            .append("defaultTime", getDefaultTime())
            .append("craeteBy", getCraeteBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
