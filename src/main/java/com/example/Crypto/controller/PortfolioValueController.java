package com.example.Crypto.controller;

import com.example.Crypto.service.CryptoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio-value")
class PortfolioValueController {
    
    private final CryptoService cryptoService;
    
    public PortfolioValueController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }
    
    @GetMapping
    public String getPortfolioValue() {
        double value = cryptoService.getPortfolioValue();
        return String.format("Celková hodnota portfolia: $%.2f", value);
    }
}