package com.general.carparking.vehicle_parking;


import com.general.carparking.common.SearchCriteria;
import com.general.carparking.parking.Parking;
import com.general.carparking.parking.ParkingDTO;
import com.general.carparking.parking.ParkingMapper;
import com.general.carparking.vehicle.IVehicleService;
import com.general.carparking.vehicle.Vehicle;
import com.general.carparking.vehicle.VehicleDTO;
import com.general.carparking.vehicle.VehicleMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/vehicle-parking-controller/")
@AllArgsConstructor
public class VehicleParkingController {

    private final IVehicleParkingService service;
    private final IVehicleService vehicleService;

    private VehicleParkingMapper mapper;
    private ParkingMapper parkingMapper;
    private VehicleMapper vehicleMapper;

    @PostMapping("/save-vehicle-parking")
    public ResponseEntity save(@RequestBody VehicleParkingDTO vehicleParkingDTO){
        VehicleParking vehicleParking = mapper.toVehicleParking(vehicleParkingDTO);
        service.save(vehicleParking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/get-cost")
    public ResponseEntity getCostByCarPlaque(@RequestBody VehicleDTO vehicleDTO){
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleDTO);
       // service.save(vehicleParking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<VehicleParkingDTO> getById(@PathVariable Long id){
        VehicleParking vehicleParking = service.getById(id);
        VehicleParkingDTO vehicleParkingDTO = mapper.toVehicleParkingDTO(vehicleParking);
        return ResponseEntity.ok(vehicleParkingDTO);
    }

    @GetMapping("/get-all-vehicle-parking/")
    public ResponseEntity<List<VehicleParkingDTO>> getAll(){
        List<VehicleParking> vehicleParking = service.getAll();
        List<VehicleParkingDTO> vehicleParkingDTO = mapper.toVehicleParkingDTOs(vehicleParking);
        return ResponseEntity.ok(vehicleParkingDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-parking/{parkingId}")
    public ResponseEntity<List<VehicleParkingDTO>> getByParkingId(@PathVariable Long parkingId){
        List<VehicleParking> vehicleParking = service.getAllByParking(parkingId);
        List<VehicleParkingDTO> vehicleParkingDTO = mapper.toVehicleParkingDTOs(vehicleParking);
        return ResponseEntity.ok(vehicleParkingDTO);
    }

    @GetMapping("/get-by-vehicle/{vehicleId}")
    public ResponseEntity<List<VehicleParkingDTO>> getByVehicleId(@PathVariable Long vehicleId){
        List<VehicleParking> vehicleParking = service.getAllByVehicle(vehicleId);
        List<VehicleParkingDTO> vehicleParkingDTO = mapper.toVehicleParkingDTOs(vehicleParking);
        return ResponseEntity.ok(vehicleParkingDTO);
    }


    @PostMapping("/search")
    public ResponseEntity<List<VehicleParkingDTO>> search(@RequestBody List<SearchCriteria> searchCriteria){
        List<VehicleParking> vehicleParkingList=  service.search(searchCriteria);
        List<VehicleParkingDTO> vehicleParkingDTOS=mapper.toVehicleParkingDTOs(vehicleParkingList);

        return ResponseEntity.ok(vehicleParkingDTOS);
    }


}
