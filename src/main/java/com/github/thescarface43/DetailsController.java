package com.github.thescarface43;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.thescarface43.DTOs.WarehouseStateDTO;
import com.github.thescarface43.interfaces.OperationInterface;

@Controller
public class DetailsController {
    
    @Autowired
    OperationInterface operationInterface;

    @GetMapping("/details/{locationId}/{wareId}")
    public String details (@PathVariable("locationId") Long locationId, @PathVariable("wareId") Long wareId, Model model) {
        Optional<WarehouseStateDTO> localWare = operationInterface.getWareDetails(locationId, wareId);
        if(localWare.isEmpty()) {
            return "error";
        }
        model.addAttribute("localWare", localWare.get());
        return "details";
    }
}
