package com.example.Chapter12.controller;

import com.example.Chapter12.model.Purchase;
import com.example.Chapter12.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
//@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
//    @PostMapping
//    public void storePurchase(@RequestBody Purchase purchase){
//        purchaseRepository.storePurchase(purchase);
//    }
    @GetMapping("/purchase")
    public String viewPurchase(Model model){
        List<Purchase> purchases = purchaseRepository.findAllPurchases();
        model.addAttribute("purchases",purchases);

        return "purchase.html";
    }
    @PostMapping("/purchase")
    public String storePurchase(
            @RequestParam String product,
            @RequestParam double price,
            Model model){
        Purchase purchase = new Purchase();
        purchase.setProduct(product);
        purchase.setPrice(BigDecimal.valueOf(price));
        purchaseRepository.storePurchase(purchase);

        List<Purchase> purchases = purchaseRepository.findAllPurchases();
        model.addAttribute("purchases",purchases);
        return "purchases.html";
    }
    @GetMapping("/purchases")
    public String findPurchases(Model model){
        List<Purchase> purchases = purchaseRepository.findAllPurchases();
        model.addAttribute("purchases",purchases);
        return "purchases.html";
    }
}
