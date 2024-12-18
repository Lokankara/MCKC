package com.mvc.commence.controllers;

import com.mvc.commence.model.Product;
import com.mvc.commence.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    private final ProductService productService;

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        System.out.println("search");
        List<Product> products = productService.findBySearch(search);
        System.out.println(products);
        model.addAttribute("products", products);
        return "search";
    }
}
