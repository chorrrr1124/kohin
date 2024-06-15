package com.ephdgs.kohin.warehouse.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ephdgs.kohin.warehouse.pojo.po.KohinIoProductPO;
import com.ephdgs.kohin.warehouse.pojo.vo.KohinIoProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface KohinIoProductDAO extends BaseMapper <KohinIoProductPO>{
    @Select("SELECT kp.`name`, kp.`code`, kp.`series`, kp.`spec` ->> \"$.width\" AS width,kp.`spec` ->> \"$.length\" AS length,kp.`spec` ->> \"$.warpage\" AS warpage, iop.`price`,iop.num, kp.`unit` FROM kohin_io_product  iop LEFT JOIN kohin_warehouse_product wp ON wp.kohin_warehouse_product_id = iop.kohin_warehouse_product_id LEFT JOIN kohin_product kp ON kp.kohin_product_id = wp.kohin_product_id WHERE iop.kohin_io_product_id = #{kohinIoProductId}")
    IPage<KohinIoProductVO> selectIoProductPOPage(Page<KohinIoProductPO> page, Integer kohinIoProductId);
}
