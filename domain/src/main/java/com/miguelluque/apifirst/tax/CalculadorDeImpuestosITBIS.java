package com.miguelluque.apifirst.tax;

public class CalculadorDeImpuestosITBIS implements CalculadorDeImpuestos {
    @Override
    public double calcularImpuesto(double precio) {
        return precio * 0.18;
    }
}