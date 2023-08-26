package com.zaga.repository;

import com.zaga.entity.CarServiceDetails;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarServiceRepo implements PanacheRepository<CarServiceDetails>{

public CarServiceDetails getCarServiceDetails(String carNumber ,String customerName){
   CarServiceDetails fetchedDetails = CarServiceDetails.find("carNumber=?1 and customerName=?2",carNumber,customerName).firstResult();
   return fetchedDetails;
}


    



}
