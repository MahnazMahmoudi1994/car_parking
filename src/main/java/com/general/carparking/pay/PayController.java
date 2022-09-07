package com.general.carparking.pay;



import com.general.carparking.common.SearchCriteria;
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
@RequestMapping(value = "/pay-controller/")
@AllArgsConstructor
public class PayController {

    private final IPayService service;

    private PayMapper mapper;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody PayDTO payDTO){
        Pay pay = mapper.toPay(payDTO);
        service.save(pay);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody PayDTO payDTO){
        Pay pay =mapper.toPay(payDTO);

        service.update(pay);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<PayDTO> getById(@PathVariable Long id ){

        Pay pay= service.getById(id);
        PayDTO payDTO=mapper.toPayDTO(pay);
        return ResponseEntity.ok(payDTO);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<PayDTO>> getAll(){

        List<Pay> payList=    service.getAll();


        List<PayDTO> payDTOS=    mapper.toPayDTOs(payList);


        return ResponseEntity.ok(payDTOS);
    }

}
