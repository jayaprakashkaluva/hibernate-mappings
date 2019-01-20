package com.jp.userservice.to;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTo {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private AddressTo shippingAddress;
    private AddressTo billingAddress;
}
