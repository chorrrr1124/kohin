package com.ephdgs.kohin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.kohin.pojo.po.KohinSalePO;
import com.ephdgs.kohin.pojo.po.KohinSaleProductPO;
import com.ephdgs.kohin.pojo.vo.KohinSaleProductVO;
import com.ephdgs.kohin.pojo.vo.KohinSaleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KohinSaleDAO extends BaseMapper<KohinSalePO> {
    @Select("SELECT so.`code`, so.province, so.city, so.district, so.detail_address, so.consignee_name, so.consignee_mobile,`user`.nickname, so.payment_method FROM kohin_sale so LEFT JOIN sys_user `user` ON `user`.user_id = so.user_id WHERE so.user_id = #{userId}")
    IPage<KohinSaleVO> selectSaleOrderPage(Page<KohinSalePO> page, Integer userId);

    @Select("SELECT product.`code` AS kohin_product_code, product.`name`, product.price, product.type, product.series, sp.num, sp.discount ,product.unit, product.spec FROM kohin_product product LEFT JOIN kohin_sale_product sp ON sp.kohin_product_id = product.kohin_product_id WHERE sp.kohin_sale_id = #{saleOrderId}")
    IPage<KohinSaleProductVO> selectSaleOrderProductPage(Page<KohinSaleProductPO> page, Integer saleOrderId);
}