package com.manuable.app.product.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manuable.app.product.models.Product;
import com.manuable.app.product.services.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String products(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "createproduct";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        try {
            productService.saveProduct(product);
            redirectAttributes.addFlashAttribute("message", "Product created successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to create product. Please try again.");
        }
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id") Long id, Model model) {
        Optional<Product> product = productService.getById(id);
        if (product.isPresent()) {
            Product prod = product.get();
            System.out.println("Editing Product: " + prod);
            model.addAttribute("product", prod);
            return "editproduct";
        }
        return "redirect:/products";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute Product product,
            RedirectAttributes redirectAttributes) {
        try {
            product.setId(id);
            productService.saveProduct(product);
            redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to update product. Please try again.");
        }
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            productService.deleteProduct(id);
            redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Failed to delete product. Please try again.");
        }
        return "redirect:/products";
    }
}
