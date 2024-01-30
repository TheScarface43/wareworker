package com.github.thescarface43;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.thescarface43.DTOs.WarehouseStateDTO;
import com.github.thescarface43.interfaces.OperationInterface;

@Controller
public class MainController {

	@Autowired
	OperationInterface operationInterface;

	@GetMapping("/main")
	public String main(Model model) {
		Pageable requestedPage = PageRequest.of(0, 50, Sort.by("ware.name", "location.rack", "location.spot", "location.level"));
		Page<WarehouseStateDTO> state = operationInterface.getWarehouseState(requestedPage);
		model.addAttribute("state", state);
		return "main";
	}
}