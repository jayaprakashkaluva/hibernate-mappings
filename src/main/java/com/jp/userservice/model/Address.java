package com.jp.userservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {
    @Id
    private long addressId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String address2;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String country;
    @Column
    private String zipCode;
    @Column
    private String address1;
}
