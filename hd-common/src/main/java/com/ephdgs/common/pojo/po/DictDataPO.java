package com.ephdgs.common.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description:
 * @Date: 2024/2/28
 * @Author: Hill
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_dict_data")
public class DictDataPO extends BasePO{
    @TableId(type = IdType.AUTO)
    private Integer dictDataId;
    private Integer dictId;
    private String name;
    private String val;
    private Integer seq;
    private String code;
}
