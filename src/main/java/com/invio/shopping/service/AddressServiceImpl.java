package com.invio.shopping.service;

import com.invio.shopping.entity.Address;
import com.invio.shopping.exceptions.CommonException;
import com.invio.shopping.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;
    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            return addressOptional.get();
        }
        throw new CommonException("Addres is not exist with given id " + id, HttpStatus.NOT_FOUND);

    }

    @Override
    public Address delete(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            addressRepository.delete(addressOptional.get());
            return addressOptional.get();
        }
        throw new CommonException("Addres is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Address update(Long id, Address address) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            Address existingAddress = addressOptional.get();
            existingAddress.setTitle(address.getTitle());
            existingAddress.setCity(address.getCity());
            existingAddress.setCountry(address.getCountry());
            addressRepository.save(existingAddress);
            return existingAddress;
        }
        throw new CommonException("Addres is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }
}
