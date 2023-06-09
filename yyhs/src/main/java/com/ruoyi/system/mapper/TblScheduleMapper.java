package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TblSchedule;
import com.ruoyi.system.domain.vo.ScheduleResponse;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-04-02
 */
public interface TblScheduleMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblScheduleById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblScheduleByIds(Long[] ids);
}
