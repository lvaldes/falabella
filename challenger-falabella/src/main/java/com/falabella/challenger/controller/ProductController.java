package com.falabella.challenger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.falabella.challenger.entity.Product;
import com.falabella.challenger.repository.ProductRepository;

@Controller
@RequestMapping("/products/")
public class ProductController {

	private final ProductRepository productRepository;

	@Autowired
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@GetMapping("signup")
	public String showSignUpForm(Product product) {
		return "add-product";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addProduct(@Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-product";
		}

		productRepository.save(product);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
		model.addAttribute("product", product);
		return "update-product";
	}

	@PostMapping("update/{id}")
	public String updateProduct(@PathVariable("id") long id, @Valid Product product, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			product.setId(id);
			return "update-product";
		}

		productRepository.save(product);
		model.addAttribute("products", productRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteProduct(@PathVariable("id") long id, Model model) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
		productRepository.delete(product);
		model.addAttribute("products", productRepository.findAll());
		return "index";
	}
}
