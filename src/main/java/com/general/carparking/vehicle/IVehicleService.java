package com.general.carparking.vehicle;



import com.general.carparking.common.SearchCriteria;

import java.util.List;

public interface IVehicleService {

    Vehicle save(Vehicle vehicle);
    Vehicle update(Vehicle vehicle);
    void delete(Long id);
    Vehicle getById (Long id);
    List<Vehicle> getAll ();


    List<Vehicle> search(List<SearchCriteria> searchCriteria);
}

