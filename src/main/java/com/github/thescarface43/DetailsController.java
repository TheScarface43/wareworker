package com.github.thescarface43;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.thescarface43.DTOs.WarehouseStateDTO;
import com.github.thescarface43.interfaces.LocationInterface;
import com.github.thescarface43.interfaces.OperationInterface;
import com.github.thescarface43.interfaces.UserInterface;
import com.github.thescarface43.interfaces.WareInterface;

import jakarta.persistence.EntityNotFoundException;

import com.github.thescarface43.entities.LocationEntity;
import com.github.thescarface43.entities.OperationEntity;
import com.github.thescarface43.entities.WareEntity;
import com.github.thescarface43.entities.WarehouseUserEntity;

@Controller
public class DetailsController {
    
    @Autowired
    OperationInterface operationInterface;
    @Autowired
    WareInterface wareInterface;
    @Autowired
    UserInterface userInterface;
    @Autowired
    LocationInterface locationInterface;

    @GetMapping("/details/{locationId}/{wareId}")
    public String details (@PathVariable("locationId") Long locationId, @PathVariable("wareId") Long wareId, Model model) {
        Optional<WarehouseStateDTO> localWare = operationInterface.getWareDetails(locationId, wareId);
        if(localWare.isEmpty()) {
            return "error";
        }
        model.addAttribute("localWare", localWare.get());
        return "details";
    }

    @PostMapping("/details/{locationId}/{wareId}")
    public String processAction(@PathVariable("locationId") Long locationId, @PathVariable("wareId") Long wareId, @RequestParam("inputField") String amountString,
    @RequestParam("inputType") String typeString, Model model) {
        try {
            BigDecimal amount = new BigDecimal(amountString);
            if(!typeString.equals("ADD") && !typeString.equals("TAKE")) {
                return "error";
            }

            WarehouseUserEntity user = userInterface.findById(Long.valueOf(1)).orElseThrow(() -> new EntityNotFoundException("user"));
            WareEntity ware = wareInterface.findById(wareId).orElseThrow(() -> new EntityNotFoundException("ware"));
            LocationEntity location = locationInterface.findById(locationId).orElseThrow(() -> new EntityNotFoundException("location"));
            Integer type = 0;

            if(typeString.equals("ADD")) {
                type = 1;
            }
            if(typeString.equals("TAKE")) {
                type = 2;
            }

            OperationEntity newOperation = new OperationEntity(type, amount, user, ware, location);
            OperationEntity savedOperation = operationInterface.save(newOperation);

            if(newOperation.equals(savedOperation)) {
                model.addAttribute("actionResult", "Success!");
            } else {
                model.addAttribute("actionResult", "Error - could not perform the requested operation.");
            }

            Optional<WarehouseStateDTO> localWare = operationInterface.getWareDetails(locationId, wareId);
            model.addAttribute("localWare", localWare.orElseThrow(() -> new EntityNotFoundException("localWare")));

            return "details";
        } catch (NumberFormatException e) {
            return "error";
        } catch (EntityNotFoundException e) {
            return "error";
        }
    }
}
