package com.invio.shopping.service;

import com.invio.shopping.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    String save(String complaint);

    List<Complaint> findAll();
}
