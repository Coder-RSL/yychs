package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TblOrder;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-04-02
 */
public interface ITblOrderService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TblOrder selectTblOrderById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TblOrder> selectTblOrderList(TblOrder tblOrder);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblOrder 【请填写功能名称】
     * @return 结果
     */
    public int insertTblOrder(TblOrder tblOrder);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblOrder 【请填写功能名称】
     * @return 结果
     */
    public int updateTblOrder(TblOrder tblOrder);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteTblOrderByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTblOrderById(Long id);
}
