package com.miguelluque.apifirst.usecase;

import com.miguelluque.apifirst.dto.PaginatedProductResponse;
import com.miguelluque.apifirst.dto.ProductoCreateDto;
import com.miguelluque.apifirst.dto.ProductoDto;

public interface ManageProductUseCase {

    PaginatedProductResponse getProductsByFilter(String nombre, String descripcion, Double precioMin, Double precioMax, Integer page, Integer size);

    PaginatedProductResponse getProductList(Integer page, Integer size);

    ProductoDto getProductById(Long id);

    ProductoDto createProduct(ProductoCreateDto producto);

    ProductoDto updateProduct(Long id, ProductoCreateDto productoDto);

    void deleteProduct(Long id);
}
