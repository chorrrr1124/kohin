package com.ephdgs.kohin.warehouse.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.kohin.warehouse.pojo.po.KohinWarehouseLogPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinWarehouseLogVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KohinWarehouseLogDAO extends BaseMapper<KohinWarehouseLogPO> {
@Select("SELECT kp.`name`, kp.`code`, wl.type, kp.`series`, kp.`spec` ->> \"$.width\" AS width, kp.`spec` ->> \"$.length\" AS length, kp.`spec` ->> \"$.warpage\" AS warpage, kp.`unit`, wl.num FROM kohin_warehouse_log wl LEFT JOIN kohin_warehouse_product wp ON wp.kohin_warehouse_product_id = wl.kohin_warehouse_product_id LEFT JOIN kohin_product kp ON kp.kohin_product_id = wp.kohin_product_id WHERE wl.kohin_warehouse_log_id = #{kohinWarehouseLogId}")
    IPage<KohinWarehouseLogVO> selectWarehouseLogPOPage(Page<KohinWarehouseLogPO> page, Integer kohinWarehouseLogId);
}
