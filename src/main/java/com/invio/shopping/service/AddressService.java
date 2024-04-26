package com.invio.shopping.service;

import com.invio.shopping.entity.Address;

import java.util.List;

public interface AddressService {

    Address save(Address address);

    List<Address> findAll();

    Address findById(Long id);

    Address delete(Long id);

    Address update(Long id,Address address);


}
