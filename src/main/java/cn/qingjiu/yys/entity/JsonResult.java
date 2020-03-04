package cn.qingjiu.yys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel
@Data
public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(
            value = "状态码",
            notes = "0是成功,其他都是失败"
    )
    private int code;
    @ApiModelProperty(
            value = "状态码描述信息",
            notes = "例如失败，参数错误"
    )
    private String msg;
    @ApiModelProperty(
            value = "具体的业务数据",
            notes = ""
    )
    private T data;


}
