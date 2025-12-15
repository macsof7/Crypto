package com.example.Crypto.controller;

import com.example.Crypto.model.Crypto;
import com.example.Crypto.service.CryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cryptos")
public class CryptoController {
    
    private final CryptoService cryptoService;
    
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }
    
    @PostMapping
    public ResponseEntity<Crypto> addCrypto(@RequestBody Crypto crypto) {
        Crypto added = cryptoService.addCrypto(crypto);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Crypto> getAllCryptos(@RequestParam(required = false) String sort) {
        return cryptoService.getAllCryptos(sort);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Crypto> getCryptoById(@PathVariable Integer id) {
        Crypto crypto = cryptoService.getCryptoById(id);
        return ResponseEntity.ok(crypto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Crypto> updateCrypto(@PathVariable Integer id, @RequestBody Crypto updatedData) {
        Crypto updated = cryptoService.updateCrypto(id, updatedData);
        return ResponseEntity.ok(updated);
    }
}