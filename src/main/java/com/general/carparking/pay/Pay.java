package com.general.carparking.pay;


import com.general.carparking.common.BaseEntity;
import com.general.carparking.vehicle.CarType;
import com.general.carparking.vehicle.Vehicle;
import com.general.carparking.vehicle_parking.VehicleParking;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_pay")
@Data
public class Pay extends BaseEntity {

    @NotNull
    @Column(name="is_success_pay")
    @Enumerated(value = EnumType.STRING)
    private PayEnum isSuccessPay;


    @OneToOne
    @JoinColumn(name = "vehicle_id",unique = true)
    private Vehicle vehicle;







}
