package com.ephdgs.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ephdgs.common.pojo.dto.DictDTO;
import com.ephdgs.common.pojo.po.DictPO;

import java.util.List;

/**
 * @Description:
 * @Date: 2024/3/7 11:03
 * @Author: Hill
 */
public interface DictService extends IService<DictPO> {
    List<DictDTO> getDictListByCode(String code);

}
