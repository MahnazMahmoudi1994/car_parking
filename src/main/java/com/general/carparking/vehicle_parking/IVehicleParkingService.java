package com.general.carparking.vehicle_parking;


import com.general.carparking.common.SearchCriteria;
import com.general.carparking.parking.Parking;
import com.general.carparking.vehicle.Vehicle;

import java.util.List;

public interface IVehicleParkingService {

    VehicleParking save(VehicleParking vehicleParking);

    void delete(Long id);

    VehicleParking getById (Long id);

    List<VehicleParking> getAll ();

    List<VehicleParking> getAllByParking(Long parkingId);

    List<VehicleParking> getAllByVehicle(Long vehicleId);


    List<VehicleParking> search(List<SearchCriteria> searchCriteria);

    Double getAllByVehicleCarPlaque(String carPlaque);



    /*List<VehicleParking> getAllByCarPlaque(String carPlaque);*/

    /*Date getCheckinTime(VehicleParking vehicleParking);*/
}
