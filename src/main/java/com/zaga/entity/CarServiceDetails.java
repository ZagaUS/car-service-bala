package com.zaga.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarServiceDetails extends PanacheEntity {
    private String carNumber;
    private String customerName;
    private CarEnum serviceStatus;
    private boolean deliveryAvailableStatus;
    private boolean deliveredStatus;

}
