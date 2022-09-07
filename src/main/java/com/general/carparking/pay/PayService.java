package com.general.carparking.pay;


import com.general.carparking.parking.Parking;
import com.general.carparking.pricerate.PriceRate;
import com.general.carparking.vehicle.IVehicleService;
import com.general.carparking.vehicle.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PayService implements IPayService {
    private final PayRepository repository;
    private final IVehicleService service;


    @Override
    public Pay save(Pay pay) {

        Long vehicleId = pay.getVehicle().getId();
        Vehicle vehicle = service.getById(vehicleId);
        pay.setVehicle(vehicle);

        return repository.save(pay);
    }


    @Override
    public Pay update(Pay pay) {

        Pay lastSavedPay=getById(pay.getId());

        lastSavedPay.setIsSuccessPay(pay.getIsSuccessPay());
        return repository.save(lastSavedPay);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Pay getById(Long id) {

        Optional<Pay> optionalPay=repository.findById(id);

        if (!optionalPay.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalPay.get();
    }



    @Override
    public List<Pay> getAll() {
        return (List<Pay>) repository.findAll();
    }

}






