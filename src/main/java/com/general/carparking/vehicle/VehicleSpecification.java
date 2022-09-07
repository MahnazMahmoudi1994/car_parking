package com.general.carparking.vehicle;

import com.general.carparking.common.SearchCriteria;
import com.general.carparking.common.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VehicleSpecification  implements Specification<Vehicle> {



    private List<SearchCriteria> list;

    public VehicleSpecification() {
        this.list = new ArrayList<>();
    }

    public void add(SearchCriteria criteria){

        list.add(criteria);
    }


    @Override
    public Predicate toPredicate(Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        //create a new predicate list
        List<Predicate> predicates = new ArrayList<>();

        //add add criteria to predicates
        for (SearchCriteria criteria : list) {

            if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add((Predicate) builder.like(
                        builder.lower(root.get(criteria.getKey())),
                        "%" + criteria.getValue().toString().toLowerCase() + "%"));
            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
