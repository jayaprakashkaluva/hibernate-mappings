package com.jp.userservice.util;

import com.jp.userservice.model.Address;
import com.jp.userservice.model.User;
import com.jp.userservice.to.AddressTo;
import com.jp.userservice.to.UserTo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserServiceUtil {

    public static User mapUserToUser(final UserTo userTo) {
        User user = new User();
        user.setEmail(userTo.getEmail());
        user.setPassword(userTo.getPassword());
        user.setFirstName(userTo.getFirstName());
        user.setLastName(userTo.getLastName());
        Address billingAddress = mapAddress(userTo.getBillingAddress());
        Address shippingAddress = mapAddress(userTo.getShippingAddress());
        List<Address> address = user.getShippingAddress() == null ? new ArrayList<Address>() : user.getShippingAddress();
        user.setBillingAddress(billingAddress);
        address.add(shippingAddress);
        user.setShippingAddress(address);
        return user;
    }
    public static Address mapAddress(final AddressTo addressTo) {
        Address address = new Address();
        address.setFirstName(addressTo.getFirstName());
        address.setLastName(addressTo.getLastName());
        address.setAddress1(addressTo.getAddress1());
        address.setAddress2(addressTo.getAddress2());
        address.setCity(addressTo.getCity());
        address.setState(addressTo.getState());
        address.setCountry(addressTo.getCountry());
        address.setZipCode(addressTo.getZipCode());
        return address;
    }
    public static Address mapAddress(final Address address,final AddressTo addressTo) {
        address.setFirstName(addressTo.getFirstName());
        address.setLastName(addressTo.getLastName());
        address.setAddress1(addressTo.getAddress1());
        address.setAddress2(addressTo.getAddress2());
        address.setCity(addressTo.getCity());
        address.setState(addressTo.getState());
        address.setCountry(addressTo.getCountry());
        address.setZipCode(addressTo.getZipCode());
        return address;
    }

    public static Address findAddressById(final List<Address> addresses,final long addressId){
        Iterator<Address> iterator = addresses.iterator();
        while(iterator.hasNext()) {
            Address address = iterator.next();
            if(addressId == address.getAddressId()) {

                return address;
            }
        }
        return null;
    }

    public static void removeAddress(final List<Address> addresses,final long addressId){
        Iterator<Address> iterator = addresses.iterator();
        while(iterator.hasNext()) {
            Address address = iterator.next();
            if (addressId == address.getAddressId()) {

                iterator.remove();
            }
        }
    }
}
