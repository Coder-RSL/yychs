package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TblPatientMapper;
import com.ruoyi.system.domain.TblPatient;
import com.ruoyi.system.service.ITblPatientService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class TblPatientServiceImpl implements ITblPatientService 
{
    @Autowired
    private TblPatientMapper tblPatientMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TblPatient selectTblPatientById(Long id)
    {
        return tblPatientMapper.selectTblPatientById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblPatient 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TblPatient> selectTblPatientList(TblPatient tblPatient)
    {
        return tblPatientMapper.selectTblPatientList(tblPatient);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblPatient 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblPatient(TblPatient tblPatient)
    {
        tblPatient.setCreateTime(DateUtils.getNowDate());
        return tblPatientMapper.insertTblPatient(tblPatient);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblPatient 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTblPatient(TblPatient tblPatient)
    {
        tblPatient.setUpdateTime(DateUtils.getNowDate());
        return tblPatientMapper.updateTblPatient(tblPatient);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblPatientByIds(Long[] ids)
    {
        return tblPatientMapper.deleteTblPatientByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblPatientById(Long id)
    {
        return tblPatientMapper.deleteTblPatientById(id);
    }
}
