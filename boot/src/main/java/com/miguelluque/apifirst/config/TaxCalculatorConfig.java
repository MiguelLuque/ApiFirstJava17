package com.miguelluque.apifirst.config;

import com.miguelluque.apifirst.tax.CalculadorDeImpuestos;
import com.miguelluque.apifirst.tax.CalculadorDeImpuestosITBIS;
import com.miguelluque.apifirst.tax.CalculadorDeImpuestosIVA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TaxCalculatorConfig {


    private final String IVA = "IVA";
    private final String ITBIS = "ITBIS";

    @Value("${app.tax.calculator}")
    private String taxCalculatorType;

    @Bean
    public CalculadorDeImpuestos calculadorDeImpuestos() {
        if (IVA.equalsIgnoreCase(taxCalculatorType)) {
            log.info("Utilizando IVA como impuesto");
            return new CalculadorDeImpuestosIVA();
        } else if (ITBIS.equalsIgnoreCase(taxCalculatorType)) {
            log.info("Utilizando ITBIS como impuesto");
            return new CalculadorDeImpuestosITBIS();
        } else {
            throw new IllegalArgumentException("Tipo de calculador de impuestos no soportado: " + taxCalculatorType);
        }
    }
}