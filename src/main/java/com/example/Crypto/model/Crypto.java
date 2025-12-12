package com.example.Crypto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crypto {
    
    private Integer id;
    private String name;
    private String symbol;
    private Double price;
    private Double quantity;
    
}