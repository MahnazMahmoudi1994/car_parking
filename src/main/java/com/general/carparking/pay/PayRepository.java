package com.general.carparking.pay;



import com.general.carparking.vehicle.Vehicle;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PayRepository extends PagingAndSortingRepository<Pay, Long> {





}
