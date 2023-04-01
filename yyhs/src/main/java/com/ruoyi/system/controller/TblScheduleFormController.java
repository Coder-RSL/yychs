package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TblScheduleForm;
import com.ruoyi.system.service.ITblScheduleFormService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生排班模板
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@RestController
@RequestMapping("/system/form")
public class TblScheduleFormController extends BaseController
{
    @Autowired
    private ITblScheduleFormService tblScheduleFormService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:form:list')")
    @GetMapping("/list")
    public TableDataInfo list(TblScheduleForm tblScheduleForm)
    {
        startPage();
        List<TblScheduleForm> list = tblScheduleFormService.selectTblScheduleFormList(tblScheduleForm);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:form:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TblScheduleForm tblScheduleForm)
    {
        List<TblScheduleForm> list = tblScheduleFormService.selectTblScheduleFormList(tblScheduleForm);
        ExcelUtil<TblScheduleForm> util = new ExcelUtil<TblScheduleForm>(TblScheduleForm.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:form:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tblScheduleFormService.selectTblScheduleFormById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:form:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TblScheduleForm tblScheduleForm)
    {
        return toAjax(tblScheduleFormService.insertTblScheduleForm(tblScheduleForm));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:form:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TblScheduleForm tblScheduleForm)
    {
        return toAjax(tblScheduleFormService.updateTblScheduleForm(tblScheduleForm));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:form:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tblScheduleFormService.deleteTblScheduleFormByIds(ids));
    }
}
