package com.ephdgs.kohin.warehouse.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseOrderPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KohinWarehouseOrderDAO extends BaseMapper<KohinWarehouseOrderPO> {
@Select("SELECT kp.`name`, kp.`code`, wl.type, wo.`io_date`, kp.`series`, kp.`spec` ->> \"$.width\" AS width, kp.`spec` ->> \"$.length\" AS length, kp.`spec` ->> \"$.warpage\" AS warpage, kp.`unit`, wl.num FROM kohin_warehouse_order wo LEFT JOIN kohin_warehouse_product wp ON wp.kohin_warehouse_id = wo.kohin_warehouse_id LEFT JOIN kohin_warehouse_log wl ON wp.kohin_warehouse_product_id = wl.kohin_warehouse_product_id LEFT JOIN kohin_product kp ON kp.kohin_product_id = wp.kohin_product_id WHERE wo.kohin_warehouse_id = #{kohinWarehouseId}")
IPage<KohinWarehouseOrderVO> selectWarehouseOrderPOPage(Page<KohinWarehouseOrderPO> page, Integer kohinWarehouseId);
}
