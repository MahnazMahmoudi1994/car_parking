package com.general.carparking.vehicle_parking;


import com.general.carparking.parking.Parking;
import com.general.carparking.vehicle.Vehicle;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleParkingRepository extends PagingAndSortingRepository<VehicleParking, Long>, JpaSpecificationExecutor<VehicleParking> {

    List<VehicleParking> findAllByVehicle(Vehicle vehicle);
    List<VehicleParking> findAllByParking(Parking parking);

    Double findAllByVehicleCarPlaque(Vehicle vehicle);
    //filter
    List<VehicleParking> findAll(Specification<VehicleParking> specification);

    //List<VehicleParking> findAllByCarPlaque(Vehicle vehicle);
    /*Date findAllByParking_CheckinTime(VehicleParking vehicleParking);*/


}
