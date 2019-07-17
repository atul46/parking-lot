package com.skillenza.parkinglotjava;


import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parkinglots",uniqueConstraints = {
        @UniqueConstraint(columnNames = "lot	"),
        @UniqueConstraint(columnNames = "vehicle_number")
})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @Column(name="id")
    private BigInteger id;
    
    @Column(name="created_at")
    @NotBlank
    private LocalDateTime createdAt;
    
    @Column(name="parking_amount")
    @NotBlank
    private double parkingAmount;
    
    @Column(name="parking_duration")
    @NotBlank
    private int parkingDuration;
    
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name="vehicle_number")
    @NotBlank
    private int vehicleNumber;
    
    @Column(name="lot")
    @NotBlank
    private int lot;
    
}
