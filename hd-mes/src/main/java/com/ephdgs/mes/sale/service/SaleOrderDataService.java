package com.ephdgs.mes.sale.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.mes.sale.pojo.po.SaleOrderDataPO;
import com.ephdgs.mes.sale.pojo.vo.SaleOrderDataVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/5/12 12:41
 * @Author: Hill
 */
@Mapper
public interface SaleOrderDataService extends IService<SaleOrderDataPO> {

    List<SaleOrderDataVO> getSaleOrderDataList(Integer saleOrderId);


}
