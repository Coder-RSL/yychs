package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TblSchedule;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public interface ITblScheduleService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TblSchedule selectTblScheduleById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblSchedule 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TblSchedule> selectTblScheduleList(TblSchedule tblSchedule);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblSchedule 【请填写功能名称】
     * @return 结果
     */
    public int insertTblSchedule(TblSchedule tblSchedule);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblSchedule 【请填写功能名称】
     * @return 结果
     */
    public int updateTblSchedule(TblSchedule tblSchedule);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTblScheduleByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblScheduleById(Long id);
}
