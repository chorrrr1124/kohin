package com.ephdgs.kohin.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ephdgs.common.pojo.po.BasePO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("kohin_warehouse_log")
public class KohinWarehouseLogPO extends BasePO {
    @TableId(type = IdType.AUTO)
private Integer KohinWarehouseLogId;
    private Integer kohinWarehouseId;
    private String type;
    private Integer num;
}
