package com.ruoyi.system.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TblSchedule;
import com.ruoyi.system.service.ITblScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 医生排班
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@RestController
@RequestMapping("/system/schedule")
public class TblScheduleController extends BaseController
{
    @Autowired
    private ITblScheduleService tblScheduleService;

    @GetMapping("test")
    public String test(){
        return "Helloworld";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblSchedule tblSchedule)
    {
        startPage();
        List<TblSchedule> list = tblScheduleService.selectTblScheduleList(tblSchedule);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:schedule:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblSchedule tblSchedule)
    {
        List<TblSchedule> list = tblScheduleService.selectTblScheduleList(tblSchedule);
        ExcelUtil<TblSchedule> util = new ExcelUtil<TblSchedule>(TblSchedule.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
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
    public AjaxResult add(@RequestBody TblSchedule tblSchedule)
    {
        return toAjax(tblScheduleService.insertTblSchedule(tblSchedule));
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
