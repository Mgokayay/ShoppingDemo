package com.invio.shopping.service;

import com.invio.shopping.entity.Complaint;
import com.invio.shopping.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService{

    private final ComplaintRepository complaintRepository;
    @Autowired
    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }



    @Override
    public String save(String complaint) {
        Complaint complaint1 = new Complaint();

        complaint1.setComplaintText(complaint);

        complaintRepository.save(complaint1);

        return "Complaint has been saved";

    }

    @Override
    public List<Complaint> findAll() {
        return complaintRepository.findAll();
    }
}
