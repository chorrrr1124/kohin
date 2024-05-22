package com.ephdgs.common.utils;

import com.ephdgs.common.enums.HttpStatusCodeEnum;
import lombok.Data;
import com.ephdgs.common.pojo.dto.RestfulDTO;

/**
 * @Description:
 * @Date: 2024/2/28
 * @Author: Hill
 */
@Data
public class HttpResponseUtil {

    public static RestfulDTO<Object> data(Object object) {
        RestfulDTO<Object> restfulDTO = new RestfulDTO<>();
        restfulDTO.setCode(0);
        restfulDTO.setMessage(null);
        restfulDTO.setData(object);
        return restfulDTO;
    }
    public static RestfulDTO<Object> ok(){
        return data(null);
    }
    //失败返回信息
    public static RestfulDTO<Object> error(HttpStatusCodeEnum httpStatusCodeEnum){
        RestfulDTO<Object> restfulDTO = new RestfulDTO<>();
        restfulDTO.setCode(httpStatusCodeEnum.getCode());
        restfulDTO.setMessage(httpStatusCodeEnum.getMessage());
        return restfulDTO;
    }

    public static RestfulDTO<Object> custom(Integer errCode, Object data, String errMsg) {
        RestfulDTO<Object> restfulDTO = new RestfulDTO<>();
        restfulDTO.setCode(errCode);
        restfulDTO.setMessage(errMsg);
        restfulDTO.setData(data);
        return restfulDTO;
    }

}