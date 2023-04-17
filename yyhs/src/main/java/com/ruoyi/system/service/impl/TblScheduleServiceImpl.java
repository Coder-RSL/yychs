package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.TblScheduleForm;
import com.ruoyi.system.domain.vo.ScheduleRequest;
import com.ruoyi.system.domain.vo.ScheduleResponse;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.TblScheduleFormMapper;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.utils.OrikaUtils;
import org.codehaus.commons.compiler.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TblScheduleMapper;
import com.ruoyi.system.domain.TblSchedule;
import com.ruoyi.system.service.ITblScheduleService;

import static com.ruoyi.common.utils.SecurityUtils.getUserId;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-04-02
 */
@Service
public class TblScheduleServiceImpl implements ITblScheduleService 
{
    @Autowired
    private TblScheduleMapper tblScheduleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private TblScheduleFormMapper formMapper;
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
    public List<ScheduleResponse> selectTblScheduleList(TblSchedule tblSchedule)
    {
        List<ScheduleResponse> list =new ArrayList();
        List<TblSchedule> tblSchedules = tblScheduleMapper.selectTblScheduleList(tblSchedule);
        for (TblSchedule tbl:tblSchedules){
            SysUser sysUser = sysUserMapper.selectUserById(tbl.getDoctorId());
            ScheduleResponse scheduleResponse =new ScheduleResponse();
            scheduleResponse= OrikaUtils.convert(tbl,ScheduleResponse.class);
            scheduleResponse.setDoctorName(sysUser.getNickName());
            scheduleResponse.setStatusName(getStatusName(scheduleResponse.getStatus()));
            if(StringUtils.isNotNull(tbl.getParentId())) {
                TblScheduleForm tblScheduleForm = formMapper.selectTblScheduleFormById(tbl.getParentId());
                String name = tblScheduleForm.getName();
                scheduleResponse.setSchduleFormName(name);
            }
            list.add(scheduleResponse);
        }
        return list;
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param response 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblSchedule(ScheduleResponse response)
    {
        String doctorName = response.getDoctorName();
        System.out.println(doctorName);
        SysUser sysUser = sysUserMapper.selectUserByUserName(doctorName);
        Long userId = sysUser.getUserId();
        TblSchedule tblSchedule =new TblSchedule();
        tblSchedule= OrikaUtils.convert(response,TblSchedule.class);
        tblSchedule.setDoctorId(userId);
        tblSchedule.setCreateTime(DateUtils.getNowDate());
        tblSchedule.setCreateBy(getUserId().toString());
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
        tblSchedule.setUpdateBy(String.valueOf(getUserId()));
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

    public String[] splitString(String name){
        String[] split = name.split("\\|");
        return split;
    }

    @Override
    public int addByForm(ScheduleRequest request) {
        String name =request.getName();
        String doctorName = request.getDoctorName();
        Integer day =request.getDay();
        Integer month =request.getMonth();
        Integer year =request.getYear();

        TblScheduleForm tblScheduleForm =new TblScheduleForm();
        tblScheduleForm.setName(name);
        List<TblScheduleForm> tblScheduleForms = formMapper.selectTblScheduleFormList(tblScheduleForm);
        TblScheduleForm form = tblScheduleForms.get(0);
        String time = form.getTime();
        String[] splitTime = StringUtils.split(time, "\\|");

        SysUser sysUser = sysUserMapper.selectUserByUserName(doctorName);
        Long userId1 = sysUser.getUserId();
        Long userId = sysUser.getUserId();

        for(String t:splitTime){
            String[] split = StringUtils.split(t, "-");
            String startTime =split[0];
            String endTime  = split[1];
            TblSchedule schedule =new TblSchedule();
            schedule.setStartTime(startTime);
            schedule.setEndTime(endTime);
            schedule.setDay(day);
            schedule.setMonth(month);
            schedule.setYear(year);
            schedule.setDoctorId(userId1);
            schedule.setDoctorId(userId);
            schedule.setStatus(6);
            schedule.setParentId(form.getId());
            schedule.setCreateBy(String.valueOf(getUserId()));
            tblScheduleMapper.insertTblSchedule(schedule);
        }

        return 1;
    }

    //0:未支付，1：支付中，2：支付超时，3：待使用 4：使用完成 5：未到达 6：未预约
    public String getStatusName(Integer status){
        switch(status) {
            case 6:
                return "待预约";
            case 0:
                return "未支付";
            case 1:
                return "支付中";
            case 2:
                return "支付超时";
            case 3:
                return "待使用";
            case 4:
                return "使用完成";
            case 5:
                return "未按时到达";
            default:
                return "未支付";
        }
    }
}
