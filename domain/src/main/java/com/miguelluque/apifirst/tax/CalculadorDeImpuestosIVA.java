package com.miguelluque.apifirst.tax;

public class CalculadorDeImpuestosIVA implements CalculadorDeImpuestos {
    @Override
    public double calcularImpuesto(double precio) {
        return precio * 0.21;
    }
}