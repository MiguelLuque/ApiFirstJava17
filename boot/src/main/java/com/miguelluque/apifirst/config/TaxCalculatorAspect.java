package com.miguelluque.apifirst.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TaxCalculatorAspect {

    private static final Logger logger = LoggerFactory.getLogger(TaxCalculatorAspect.class);

    @Before("execution(* com.miguelluque.apifirst.tax.CalculadorDeImpuestosIVA.calcularImpuesto(..))")
    public void beforeCalculadorDeImpuestosIVA() {
        logger.info("Utilizando CalculadorDeImpuestosIVA para calcular el impuesto.");
    }

    @Before("execution(* com.miguelluque.apifirst.tax.CalculadorDeImpuestosITBIS.calcularImpuesto(..))")
    public void beforeCalculadorDeImpuestosITBIS() {
        logger.info("Utilizando CalculadorDeImpuestosITBIS para calcular el impuesto.");
    }
}

