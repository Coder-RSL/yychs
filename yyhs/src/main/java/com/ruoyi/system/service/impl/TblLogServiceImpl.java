package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TblPatient;
import com.ruoyi.system.domain.TblSchedule;
import com.ruoyi.system.domain.vo.LogResponse;
import com.ruoyi.system.mapper.TblPatientMapper;
import com.ruoyi.system.mapper.TblScheduleMapper;
import com.ruoyi.system.utils.OrikaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TblLogMapper;
import com.ruoyi.system.domain.TblLog;
import com.ruoyi.system.service.ITblLogService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-02
 */
@Service
public class TblLogServiceImpl implements ITblLogService 
{
    @Autowired
    private TblLogMapper tblLogMapper;

    @Autowired
    private TblScheduleMapper tblScheduleMapper;

    @Autowired
    private TblPatientMapper tblPatientMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TblLog selectTblLogById(Long id)
    {
        return tblLogMapper.selectTblLogById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblLog 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<LogResponse> selectTblLogList(TblLog tblLog)
    {
        List<TblLog> tblLogs = tblLogMapper.selectTblLogList(tblLog);
        List<LogResponse> res =new ArrayList<>();
        for(TblLog log:tblLogs){
            LogResponse response=OrikaUtils.convert(log, LogResponse.class);

        }
        return res;
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblLog 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblLog(TblLog tblLog)
    {
        tblLog.setCreateTime(DateUtils.getNowDate());
        return tblLogMapper.insertTblLog(tblLog);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblLog 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTblLog(TblLog tblLog)
    {
        tblLog.setUpdateTime(DateUtils.getNowDate());
        return tblLogMapper.updateTblLog(tblLog);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblLogByIds(Long[] ids)
    {
        return tblLogMapper.deleteTblLogByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblLogById(Long id)
    {
        return tblLogMapper.deleteTblLogById(id);
    }
}
