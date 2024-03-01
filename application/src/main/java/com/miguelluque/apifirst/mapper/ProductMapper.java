package com.miguelluque.apifirst.mapper;

import com.miguelluque.apifirst.dto.PaginatedProductResponse;
import com.miguelluque.apifirst.dto.ProductoCreateDto;
import com.miguelluque.apifirst.dto.ProductoDto;
import com.miguelluque.apifirst.entity.Producto;
import com.miguelluque.apifirst.tax.CalculadorDeImpuestos;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    @Autowired
    protected CalculadorDeImpuestos calculadorDeImpuestos;

    public abstract Producto toEntity(ProductoDto productDto);

    public abstract Producto toEntity(ProductoCreateDto productDto);

    public abstract ProductoDto toDto(Producto product);

    public abstract List<ProductoDto> toDto(List<Producto> target);

    public PaginatedProductResponse toPaginatedResponse(Page<Producto> src, Integer page) {
        PaginatedProductResponse res = new PaginatedProductResponse();
        res.setProducts(this.toDto(src.getContent()));
        res.setCurrentPage(page);
        res.setTotalPages(src.getTotalPages());
        return res;
    }

    @AfterMapping
    protected void calcularImpuesto(Producto product, @MappingTarget ProductoDto productoDto) {
        double impuesto = calculadorDeImpuestos.calcularImpuesto(product.getPrecio());
        productoDto.setImpuesto(impuesto);
        productoDto.setPrecioConImpuesto(product.getPrecio() + impuesto);
    }
}
