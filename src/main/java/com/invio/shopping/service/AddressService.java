package com.invio.shopping.service;

import com.invio.shopping.dto.AddressResponse;
import com.invio.shopping.entity.Address;

import java.util.List;

public interface AddressService {

    AddressResponse save(Address address);

    List<AddressResponse> findAll();

    AddressResponse findById(Long id);

    AddressResponse delete(Long id);

    AddressResponse update(Long id,Address address);


}
