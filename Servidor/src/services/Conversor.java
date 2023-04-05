package services;

import java.util.HashMap;

public class Conversor {
    private HashMap<String, Double> moedas = new HashMap<>();

    public Conversor() {
        moedas.put("USD", 5.70);
        moedas.put("EUR", 2.0); 
        moedas.put("BRL", 1.0);       
    }
    
    public double conversorMoedas(String nome, double valorInicial, String moedaFinal){
        try {            
            double valorFinal = valorInicial * moedas.get(moedaFinal);            
            return valorFinal;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Argumentos invalidos.");
        } 
    }
}
