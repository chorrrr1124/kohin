package com.ephdgs.mes.sale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.mes.sale.pojo.po.SaleOrderPO;
import com.ephdgs.mes.sale.pojo.vo.SaleOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description:
 * @Date: 2024/5/12 12:38
 * @Author: Hill
 */
@Mapper
public interface SaleOrderDao extends BaseMapper<SaleOrderPO> {

    @Select("SELECT so.`code`, so.currency, so.delivery_method, so.delivery_point, su1.`nickname` AS business_user_name, su2.`nickname` AS check_user_name, so.check_date, so.flag, so.remark, so.create_time FROM sale_order so LEFT JOIN sys_user su1 ON su1.user_id = so.business_user_id LEFT JOIN sys_user su2 ON su2.user_id = so.check_user_id WHERE so.sale_order_id = #{index} ORDER BY so.create_time DESC")
    IPage<SaleOrderVO> queryPage(Page<SaleOrderPO> page, Integer index);

}
