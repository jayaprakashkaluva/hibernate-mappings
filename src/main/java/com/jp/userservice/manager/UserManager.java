package com.jp.userservice.manager;

import com.jp.userservice.dao.UserDao;
import com.jp.userservice.model.Address;
import com.jp.userservice.model.User;
import com.jp.userservice.to.AddressTo;
import com.jp.userservice.to.UserTo;
import com.jp.userservice.util.UserServiceUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserManager {
    private final UserDao userDao;
    public User saveUser(final UserTo userTo) {
        User user = UserServiceUtil.mapUserToUser(userTo);
        return  userDao.save(user);
    }

    public List<Address> addAddress(final long userId,final AddressTo addressTo) {
        User user = userDao.findById(userId).orElse(new User());
        Address address = UserServiceUtil.mapAddress(addressTo);
        user.getShippingAddress().add(address);
        return  userDao.save(user).getShippingAddress();
    }

    public List<Address> updateAddress(final long userId,final AddressTo addressTo,final long addressId) {
        User user = userDao.findById(userId).orElse(new User());
        List<Address> addresses = user.getShippingAddress();
        Address address = UserServiceUtil.findAddressById(addresses,addressId);
        UserServiceUtil.mapAddress(address,addressTo);
        return  userDao.save(user).getShippingAddress();
    }
    public Address updateBillingAddress(final long userId,final AddressTo addressTo) {
        User user = userDao.findById(userId).orElse(new User());
        Address address = user.getBillingAddress();
        UserServiceUtil.mapAddress(address,addressTo);
        return  userDao.save(user).getBillingAddress();
    }
    public void deleteShippingAddress(final long userId,final long addressId) {
        User user = userDao.findById(userId).orElse(new User());
        List<Address> addresses = user.getShippingAddress();
        UserServiceUtil.removeAddress(addresses,addressId);
        userDao.save(user).getShippingAddress();
    }
    public User getUser(final long userId) {
        return  userDao.findById(userId).orElse(new User());
    }
    
    public List<User> getUsers() {
        return  (List<User>) userDao.findAll();
    }
    
    public List<Address> getShippingAddresses(final long userId) {
        return  userDao.findById(userId).map(User::getShippingAddress).orElse(new ArrayList<Address>());
    }
}
