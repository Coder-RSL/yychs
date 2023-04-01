package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TblScheduleMapper;
import com.ruoyi.system.domain.TblSchedule;
import com.ruoyi.system.service.ITblScheduleService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class TblScheduleServiceImpl implements ITblScheduleService 
{
    @Autowired
    private TblScheduleMapper tblScheduleMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TblSchedule selectTblScheduleById(Long id)
    {
        return tblScheduleMapper.selectTblScheduleById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblSchedule 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TblSchedule> selectTblScheduleList(TblSchedule tblSchedule)
    {
        return tblScheduleMapper.selectTblScheduleList(tblSchedule);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblSchedule 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblSchedule(TblSchedule tblSchedule)
    {
        tblSchedule.setCreateTime(DateUtils.getNowDate());
        return tblScheduleMapper.insertTblSchedule(tblSchedule);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblSchedule 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTblSchedule(TblSchedule tblSchedule)
    {
        tblSchedule.setUpdateTime(DateUtils.getNowDate());
        return tblScheduleMapper.updateTblSchedule(tblSchedule);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblScheduleByIds(Long[] ids)
    {
        return tblScheduleMapper.deleteTblScheduleByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblScheduleById(Long id)
    {
        return tblScheduleMapper.deleteTblScheduleById(id);
    }
}
