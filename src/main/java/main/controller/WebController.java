package main.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.beans.Item;
import main.repository.CleaningRepository;

@Controller
public class WebController {

	@Autowired
	CleaningRepository repo;
	
	@GetMapping("/viewGarage")
	public String viewGarage(Model model) {
		model.addAttribute("items", repo.findAll());
		return "garage";
	}
	
	@GetMapping("/inputItem")
	public String addNewItem(Model model) {
		Item i = new Item();
		model.addAttribute("newItem", i);
		return "input";
	}
	
	@PostMapping("/inputItem")
	public String addNewItem(@ModelAttribute Item i, Model model) {
		repo.save(i);
		model.addAttribute("items", repo.findAll());
		return "garage";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Item i = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Item Id:" + id));
		model.addAttribute("item", i);
		return "update";
	}
	
	@PostMapping("/update/{id}")
	public String updateItem(@PathVariable("id") long id, @Valid Item i, BindingResult result, Model model) {
		if(result.hasErrors()) {
			i.setId(id);
			return "update";
		}
		repo.save(i);
		model.addAttribute("items", repo.findAll());
		return "garage";
	}
	
	@GetMapping("/donate/{id}")
	public String donateItem(@PathVariable("id") long id, Model model) {
		Item i = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Item Id:" + id));
		repo.delete(i);
		model.addAttribute("items", repo.findAll());
		return "garage";
	}
}
