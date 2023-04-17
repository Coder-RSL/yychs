package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TblLog;
import com.ruoyi.system.domain.vo.LogResponse;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-02
 */
public interface ITblLogService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TblLog selectTblLogById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblLog 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<LogResponse> selectTblLogList(TblLog tblLog);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblLog 【请填写功能名称】
     * @return 结果
     */
    public int insertTblLog(TblLog tblLog);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblLog 【请填写功能名称】
     * @return 结果
     */
    public int updateTblLog(TblLog tblLog);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTblLogByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblLogById(Long id);
}
