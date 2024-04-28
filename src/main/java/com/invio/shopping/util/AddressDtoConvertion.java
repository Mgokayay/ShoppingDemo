package com.invio.shopping.util;

import com.invio.shopping.dto.AddressResponse;
import com.invio.shopping.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressDtoConvertion {


    public static List<AddressResponse> convertAddressList(List<Address> addresses){
        List<AddressResponse> addressResponses = new ArrayList<>();
        addresses.stream().forEach(address -> addressResponses.add(new AddressResponse(address.getId(),address.getTitle()
        ,address.getCountry(),address.getCity(),address.getUser().getId())));
        return addressResponses;
    }

    public static AddressResponse convertAddress(Address address){
        return new AddressResponse(address.getId(),address.getTitle()
                ,address.getCountry(),address.getCity(),address.getUser().getId());
    }
}
