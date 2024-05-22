package com.ephdgs.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ephdgs.common.dao.DictDao;
import com.ephdgs.common.dao.DictDataDao;
import com.ephdgs.common.pojo.dto.DictDTO;
import com.ephdgs.common.pojo.po.DictDataPO;
import com.ephdgs.common.pojo.po.DictPO;
import com.ephdgs.common.service.DictService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2024/3/7
 * @Author: Hill
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictDao, DictPO> implements DictService {

    private DictDataDao dictDataDao;

    @Autowired
    public void setDictDataDao(DictDataDao dictDataDao) {
        this.dictDataDao = dictDataDao;
    }

    /**
     * 根据CODE获取字典列表
     * @param code
     * @return
     */
    public List<DictDTO> getDictListByCode(String code) {
        List<DictDataPO> list = dictDataDao.selectDictDataListByCode(code);
        List<DictDTO> listDto = new ArrayList<>();
        for (DictDataPO dictDataPO : list) {
            DictDTO dictDTO = new DictDTO();
            BeanUtils.copyProperties(dictDataPO, dictDTO);
            listDto.add(dictDTO);
        }
        return listDto;
    }

}
