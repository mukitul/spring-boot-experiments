package com.app.springdataexp.customerHATEOS;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DOB")
    private Date dob;
    @Column(name = "CREATED_AT")
    private Date createdAt;
    @Column(name = "UPDATE_AT")
    private Date updatedAt;


    @PrePersist
    public void prePersist() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = new Date();
    }
}
