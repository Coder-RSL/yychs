package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TblScheduleForm;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public interface TblScheduleFormMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TblScheduleForm selectTblScheduleFormById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblScheduleForm 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TblScheduleForm> selectTblScheduleFormList(TblScheduleForm tblScheduleForm);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblScheduleForm 【请填写功能名称】
     * @return 结果
     */
    public int insertTblScheduleForm(TblScheduleForm tblScheduleForm);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblScheduleForm 【请填写功能名称】
     * @return 结果
     */
    public int updateTblScheduleForm(TblScheduleForm tblScheduleForm);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblScheduleFormById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblScheduleFormByIds(Long[] ids);
}
