package com.jp.userservice.controller;

import com.jp.userservice.manager.UserManager;
import com.jp.userservice.model.Address;
import com.jp.userservice.model.User;
import com.jp.userservice.to.AddressTo;
import com.jp.userservice.to.UserTo;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserManager userManager;
    @PostMapping("/users")
    public User saveUser(@RequestBody final UserTo user) {
    return userManager.saveUser(user);
    }
    @PostMapping("/users/{user-id}/shippingAddress")
    public List<Address> addShippingAddress(@PathVariable("user-id") final long userId,@RequestBody final AddressTo address) {
        return userManager.addAddress(userId,address);
    }

    @PutMapping("/users/{user-id}/billingAddress")
    public Address updateBillingAddress(@PathVariable("user-id") final long userId,@RequestBody final AddressTo address) {
        return userManager.updateBillingAddress(userId,address);
    }


    @PutMapping("/users/{user-id}/shippingAddress/{address-id}")
    public List<Address> udateShippingAddress(@PathVariable("user-id") final long userId,@RequestBody final AddressTo address,@PathVariable("address-id") final long addressId) {
        return userManager.updateAddress(userId,address,addressId);
    }

    @DeleteMapping("/users/{user-id}/shippingAddress/{address-id}")
    public void deleteShippingAddress(@PathVariable("user-id") final long userId,@PathVariable("address-id") final long addressId) {
        userManager.deleteShippingAddress(userId,addressId);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userManager.getUsers();
    }
    
    @GetMapping("/users/{user-id}")
    public User getUser(@PathVariable("user-id") final long userId) {
        return userManager.getUser(userId);
    }
    
    @GetMapping("/users/{user-id}/shippingAddress")
    public List<Address> getShippingAddress(@PathVariable("user-id") final long userId) {
        return userManager.getShippingAddresses(userId);
    }
}
