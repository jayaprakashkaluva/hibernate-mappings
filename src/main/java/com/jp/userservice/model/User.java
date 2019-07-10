package com.jp.userservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import java.util.List;

@Entity
@Table(name="User_Details")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private long userId;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> shippingAddress;
    @OneToOne(cascade=CascadeType.ALL)
    private Address billingAddress;
}
