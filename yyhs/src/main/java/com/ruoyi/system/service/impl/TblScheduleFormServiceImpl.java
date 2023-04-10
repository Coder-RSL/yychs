package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TblScheduleFormMapper;
import com.ruoyi.system.domain.TblScheduleForm;
import com.ruoyi.system.service.ITblScheduleFormService;

import static com.ruoyi.common.utils.SecurityUtils.getUserId;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-02
 */
@Service
public class TblScheduleFormServiceImpl implements ITblScheduleFormService 
{
    @Autowired
    private TblScheduleFormMapper tblScheduleFormMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TblScheduleForm selectTblScheduleFormById(Long id)
    {
        TblScheduleForm tblScheduleForm = tblScheduleFormMapper.selectTblScheduleFormById(id);
        tblScheduleForm.setName(tblScheduleForm.getName().replaceAll("\\|","\n"));
        return tblScheduleForm;
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblScheduleForm 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TblScheduleForm> selectTblScheduleFormList(TblScheduleForm tblScheduleForm)
    {
        List<TblScheduleForm> tblScheduleForms = tblScheduleFormMapper.selectTblScheduleFormList(tblScheduleForm);
        for(TblScheduleForm form:tblScheduleForms){
            form.setTime(form.getTime().replaceAll("\\|","\n"));
        }
        return tblScheduleForms;
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblScheduleForm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblScheduleForm(TblScheduleForm tblScheduleForm)
    {
        tblScheduleForm.setCreateTime(DateUtils.getNowDate());
        return tblScheduleFormMapper.insertTblScheduleForm(tblScheduleForm);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblScheduleForm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTblScheduleForm(TblScheduleForm tblScheduleForm)
    {
        tblScheduleForm.setUpdateTime(DateUtils.getNowDate());
        tblScheduleForm.setUpdateBy(String.valueOf(getUserId()));
        return tblScheduleFormMapper.updateTblScheduleForm(tblScheduleForm);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblScheduleFormByIds(Long[] ids)
    {
        return tblScheduleFormMapper.deleteTblScheduleFormByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblScheduleFormById(Long id)
    {
        return tblScheduleFormMapper.deleteTblScheduleFormById(id);
    }
}
