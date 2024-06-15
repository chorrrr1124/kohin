package com.ephdgs.kohin.warehouse.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KohinWarehouseProductDAO extends BaseMapper <KohinWarehouseProductPO>{
    @Select("SELECT product.`name`, product.`code`, product.`spec` ->> \"$.width\" AS width, product.`spec` ->> \"$.length\" AS length, product.`spec` ->> \"$.warpage\" AS warpage, wp.num FROM kohin_warehouse_product wp LEFT JOIN kohin_product product ON product.kohin_product_id = wp.kohin_product_id WHERE wp.kohin_warehouse_id = #{kohinWarehouseId}")
    IPage<KohinWarehouseProductVO> selectWarehouseProductPOPage(Page<KohinWarehouseProductPO> page, Integer kohinWarehouseId);
}
