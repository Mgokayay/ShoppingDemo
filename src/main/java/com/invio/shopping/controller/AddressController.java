package com.invio.shopping.controller;

import com.invio.shopping.entity.Address;
import com.invio.shopping.entity.User;
import com.invio.shopping.service.AddressService;
import com.invio.shopping.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final UserService userService;

    @PostMapping("/{id}")
    public Address save(@RequestBody Address address,@PathVariable Long id){
        User user = userService.findByUserId(id);
        user.getAddressList().add(address);
        address.setUser(user);


        return addressService.save(address);
    }

    @GetMapping("/")
    public List<Address> findAll(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable Long id){
        return addressService.delete(id);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable Long id,@RequestBody Address address){
        return addressService.update(id,address);
    }
}
