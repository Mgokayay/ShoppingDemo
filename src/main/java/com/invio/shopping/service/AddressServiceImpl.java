package com.invio.shopping.service;

import com.invio.shopping.dto.AddressResponse;
import com.invio.shopping.entity.Address;
import com.invio.shopping.exceptions.CommonException;
import com.invio.shopping.repository.AddressRepository;
import com.invio.shopping.util.AddressDtoConvertion;
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
    public AddressResponse save(Address address) {
        addressRepository.save(address);
        return AddressDtoConvertion.convertAddress(address);
    }

    @Override
    public List<AddressResponse> findAll() {

        return AddressDtoConvertion.convertAddressList(addressRepository.findAll());
    }

    @Override
    public AddressResponse findById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            return AddressDtoConvertion.convertAddress(addressOptional.get());
        }
        throw new CommonException("Addres is not exist with given id " + id, HttpStatus.NOT_FOUND);

    }

    @Override
    public AddressResponse delete(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            addressRepository.delete(addressOptional.get());
            return AddressDtoConvertion.convertAddress(addressOptional.get());
        }
        throw new CommonException("Addres is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public AddressResponse update(Long id, Address address) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            Address existingAddress = addressOptional.get();
            existingAddress.setTitle(address.getTitle());
            existingAddress.setCity(address.getCity());
            existingAddress.setCountry(address.getCountry());
            addressRepository.save(existingAddress);
            return AddressDtoConvertion.convertAddress(existingAddress);
        }
        throw new CommonException("Addres is not exist with given id " + id, HttpStatus.NOT_FOUND);
    }
}
