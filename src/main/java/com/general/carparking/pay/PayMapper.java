package com.general.carparking.pay;

import com.general.carparking.vehicle.VehicleMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {VehicleMapper.class})
public interface PayMapper {

    Pay toPay(PayDTO payDTO);

    PayDTO toPayDTO(Pay pay);


    List<Pay> toPayList(List<PayDTO> payDTOS);
    List<PayDTO> toPayDTOs(List<Pay> payList);
}
