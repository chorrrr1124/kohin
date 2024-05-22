package com.ephdgs.mes.sale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ephdgs.mes.sale.pojo.po.SaleOrderDataPO;
import com.ephdgs.mes.sale.pojo.vo.SaleOrderDataVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/5/12 12:39
 * @Author: Hill
 */
@Mapper
public interface SaleOrderDataDao extends BaseMapper<SaleOrderDataPO> {
    @Select("SELECT bc.`code`, bc.`name`, bc.model, bc.unit, sod.nickname, sod.quantity, sod.delivery_date, sod.seq FROM sale_order_data sod LEFT JOIN base_commodity bc ON bc.commodity_id = sod.commodity_id WHERE sod.sale_order_id = #{saleOrderId}")
    List<SaleOrderDataVO> listBySaleOrderId(Integer saleOrderId);
}
