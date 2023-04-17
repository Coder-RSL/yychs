package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.domain.vo.ScheduleRequest;
import com.ruoyi.system.domain.vo.ScheduleResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TblSchedule;
import com.ruoyi.system.service.ITblScheduleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-04-02
 */
@RestController
@RequestMapping("/system/schedule")
public class TblScheduleController extends BaseController
{
    @Autowired
    private ITblScheduleService tblScheduleService;
    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblSchedule tblSchedule)
    {
        System.out.println(tblSchedule);
        startPage();
        List<ScheduleResponse> list = tblScheduleService.selectTblScheduleList(tblSchedule);
        return getDataTable(list);
    }


    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tblScheduleService.selectTblScheduleById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ScheduleResponse response)
    {
        return toAjax(tblScheduleService.insertTblSchedule(response));
    }

    @Log(title = "新增ByForm", businessType = BusinessType.INSERT)
    @PostMapping("/addByForm")
    public AjaxResult addByForm(@RequestBody ScheduleRequest request)
    {
        System.out.println(request);

        return toAjax(tblScheduleService.addByForm(request));
    }


    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblSchedule tblSchedule)
    {
        return toAjax(tblScheduleService.updateTblSchedule(tblSchedule));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tblScheduleService.deleteTblScheduleByIds(ids));
    }
}
