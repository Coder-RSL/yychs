package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TblPatient;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
public interface TblPatientMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TblPatient selectTblPatientById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblPatient 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TblPatient> selectTblPatientList(TblPatient tblPatient);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblPatient 【请填写功能名称】
     * @return 结果
     */
    public int insertTblPatient(TblPatient tblPatient);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblPatient 【请填写功能名称】
     * @return 结果
     */
    public int updateTblPatient(TblPatient tblPatient);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblPatientById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTblPatientByIds(Long[] ids);
}
