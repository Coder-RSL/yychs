package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TblOrderMapper;
import com.ruoyi.system.domain.TblOrder;
import com.ruoyi.system.service.ITblOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-26
 */
@Service
public class TblOrderServiceImpl implements ITblOrderService 
{
    @Autowired
    private TblOrderMapper tblOrderMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TblOrder selectTblOrderById(Long id)
    {
        return tblOrderMapper.selectTblOrderById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tblOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TblOrder> selectTblOrderList(TblOrder tblOrder)
    {
        return tblOrderMapper.selectTblOrderList(tblOrder);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tblOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTblOrder(TblOrder tblOrder)
    {
        tblOrder.setCreateTime(DateUtils.getNowDate());
        return tblOrderMapper.insertTblOrder(tblOrder);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tblOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTblOrder(TblOrder tblOrder)
    {
        tblOrder.setUpdateTime(DateUtils.getNowDate());
        return tblOrderMapper.updateTblOrder(tblOrder);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblOrderByIds(Long[] ids)
    {
        return tblOrderMapper.deleteTblOrderByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTblOrderById(Long id)
    {
        return tblOrderMapper.deleteTblOrderById(id);
    }
}
