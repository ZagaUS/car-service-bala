package com.zaga.serviceImplementation;

import java.util.List;

import com.zaga.entity.CarEnum;
import com.zaga.entity.CarServiceDetails;
import com.zaga.repository.CarServiceRepo;
import com.zaga.service.CarServiceService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CarServiceImplementation implements CarServiceService{
  @Inject
  EntityManager manager;
   
  @Inject
  CarServiceRepo repository;
     
    @Override
    @Transactional
    public CarServiceDetails createCarServiceDetails(CarServiceDetails details) {
        return manager.merge(details);
    }

    //View the details of the car using the car number and customer name

    @Override
    @Transactional
    public CarServiceDetails viewCarDetails(String carNumber,String customerName) {
             CarServiceDetails getDetails = repository.getCarServiceDetails(carNumber, customerName);
             return getDetails;
              
    }

 //When the service status of the car is updated, the delivery available status will be changed

    @Override

    public CarServiceDetails modifyCarDetails(String carNumber ,String customerName, CarEnum serviceStatus) {
                CarServiceDetails modify = repository.getCarServiceDetails(carNumber ,customerName);
                  modify.setServiceStatus(serviceStatus);
        if (serviceStatus.equals(CarEnum.COMPLETED)) {
            modify.setDeliveryAvailableStatus(true);
            modify.setDeliveredStatus(true);
        }
        return modify;
    }

      // When the car is delivered, the details of the car will be deleted. 

    @Override
    @Transactional
    public String  deleteCarDetails(boolean deliveredStatus) {
       repository.find("deliveredStatus=?1", true).firstResult().delete();
    return "successfully deleted";
                

    }




 
    
}
