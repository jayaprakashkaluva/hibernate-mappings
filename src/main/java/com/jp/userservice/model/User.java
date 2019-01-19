package com.jp.userservice.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="User_Details")
public class User {
    @Id
    private long userId;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @OneToMany
    private List<Address> shippingAddress;
    @OneToOne
    private Address billingAddress;
}
