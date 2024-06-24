package com.ephdgs.kohin.warehouse.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.kohin.warehouse.pojo.po.KohinInventoryProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinInventoryProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KohinInventoryProductDAO extends BaseMapper<KohinInventoryProductPO> {

    @Select("SELECT kp.`name`, kp.`code`, kp.`series`, kp.`spec` ->> \"$.width\" AS width,kp.`spec` ->> \"$.warpage\" AS warpage,kp.`spec` ->> \"$.length\" AS length,ip.`unit`, ip. `inventory_num`FROM kohin_inventory_product ip LEFT JOIN kohin_warehouse_product wp ON wp.kohin_warehouse_product_id = ip.kohin_warehouse_product_id LEFT JOIN kohin_product kp ON kp.kohin_product_id = wp.kohin_product_id WHERE ip.kohin_inventory_product_id =#{kohinInventoryProductId}")
        IPage<KohinInventoryProductVO> selectInventoryProductPOPage(Page<KohinInventoryProductPO> page, Integer kohinInventoryProductId);
}
