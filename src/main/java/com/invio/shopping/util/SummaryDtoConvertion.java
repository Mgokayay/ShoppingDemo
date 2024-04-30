package com.invio.shopping.util;

import com.invio.shopping.dto.SummaryResponse;
import com.invio.shopping.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class SummaryDtoConvertion {


    public static List<SummaryResponse> convertSummaryList (List<Product> productList){

        List<SummaryResponse> summaryResponses = new ArrayList<>();

        productList.stream().forEach(product -> summaryResponses.add(new SummaryResponse(product.getId()
                , product.getName(), product.getPrice(), product.getCount())));
        return summaryResponses;
    }
}
