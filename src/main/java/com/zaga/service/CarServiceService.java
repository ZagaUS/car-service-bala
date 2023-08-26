package com.zaga.service;

import com.zaga.entity.CarEnum;
import com.zaga.entity.CarServiceDetails;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface CarServiceService {
     
    public CarServiceDetails createCarServiceDetails(CarServiceDetails details);

    public CarServiceDetails viewCarDetails(String carNumber,String customerName);
    
    public CarServiceDetails modifyCarDetails(String carNumber ,String customerName, CarEnum serviceStatus);


    public String deleteCarDetails(boolean deliveredStatus);

}
