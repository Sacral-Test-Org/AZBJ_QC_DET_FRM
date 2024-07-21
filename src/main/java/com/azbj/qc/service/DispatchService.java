package com.azbj.qc.service;

import com.azbj.qc.repository.DispatchRepository;
import com.azbj.qc.model.Dispatch;
import com.azbj.qc.dto.DispatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchService {

    @Autowired
    private DispatchRepository dispatchRepository;

    public Dispatch saveDispatchDetails(DispatchDTO dispatchDTO) {
        Dispatch dispatch = new Dispatch();
        dispatch.setShipNo(dispatchDTO.getShipNo());
        dispatch.setAwbNo(dispatchDTO.getAwbNo());
        dispatch.setDelType(dispatchDTO.getDelType() != null ? dispatchDTO.getDelType() : "I");
        dispatch.setVendor(dispatchDTO.getVendor());
        dispatch.setDesType(dispatchDTO.getDesType() != null ? dispatchDTO.getDesType() : "CUST");
        dispatch.setPickReqNo(dispatchDTO.getPickReqNo());
        dispatch.setPrRef(dispatchDTO.getPrRef());
        dispatch.setConsigneeName(dispatchDTO.getConsigneeName());
        dispatch.setConAdd1(dispatchDTO.getConAdd1());
        dispatch.setConAdd2(dispatchDTO.getConAdd2());
        dispatch.setConAdd3(dispatchDTO.getConAdd3());
        dispatch.setConCity(dispatchDTO.getConCity());
        dispatch.setConState(dispatchDTO.getConState());
        dispatch.setDesPin(dispatchDTO.getDesPin());
        dispatch.setWt(dispatchDTO.getWt());
        dispatch.setGm(dispatchDTO.getGm() != null ? dispatchDTO.getGm() : "Grm");
        return dispatchRepository.save(dispatch);
    }

    public Dispatch getDispatchDetails(String contractId) {
        return dispatchRepository.findDispatchDetails(contractId);
    }

    public void clearDispatchDetails() {
        dispatchRepository.clearDispatchDetails();
    }
}
