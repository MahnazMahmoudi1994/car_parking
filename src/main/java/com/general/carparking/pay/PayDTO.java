package com.general.carparking.pay;


import com.general.carparking.common.BaseDTO;
import com.general.carparking.vehicle.CarType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class PayDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private PayEnum isSuccessPay;

}
