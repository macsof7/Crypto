package com.example.Crypto.service;

import com.example.Crypto.model.Crypto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CryptoService {
    
    private final List<Crypto> portfolio = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);
    
    public CryptoService() {
        portfolio.add(new Crypto(idGenerator.getAndIncrement(), "Bitcoin", "BTC", 65000.0, 0.5));
        portfolio.add(new Crypto(idGenerator.getAndIncrement(), "Ethereum", "ETH", 3500.0, 5.0));
        portfolio.add(new Crypto(idGenerator.getAndIncrement(), "Cardano", "ADA", 0.45, 1000.0));
    }
    
    public Crypto addCrypto(Crypto newCrypto) {
        newCrypto.setId(idGenerator.getAndIncrement());
        portfolio.add(newCrypto);
        return newCrypto;
    }
    
    public List<Crypto> getAllCryptos(String sortCriteria) {
        List<Crypto> sortedList = new ArrayList<>(portfolio);
        
        if (sortCriteria != null) {
            Comparator<Crypto> comparator = switch (sortCriteria.toLowerCase()) {
                case "name" -> Comparator.comparing(Crypto::getName);
                case "price" -> Comparator.comparing(Crypto::getPrice);
                case "quantity" -> Comparator.comparing(Crypto::getQuantity);
                default -> null;
            };
            
            if (comparator != null) {
                sortedList.sort(comparator);
            }
        }
        return sortedList;
    }
    
    public Crypto getCryptoById(Integer id) {
        return portfolio.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public Crypto updateCrypto(Integer id, Crypto updatedData) {
        Crypto existing = getCryptoById(id);
        if (existing == null) {
            return null;
        }
        existing.setName(updatedData.getName());
        existing.setSymbol(updatedData.getSymbol());
        existing.setPrice(updatedData.getPrice());
        existing.setQuantity(updatedData.getQuantity());
        return existing;
    }
    
    public double getPortfolioValue() {
        return portfolio.stream()
                .mapToDouble(c -> c.getPrice() * c.getQuantity())
                .sum();
    }
}