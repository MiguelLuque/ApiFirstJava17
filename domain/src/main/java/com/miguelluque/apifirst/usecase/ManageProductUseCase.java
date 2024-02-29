package com.miguelluque.apifirst.usecase;

import com.miguelluque.apifirst.dto.PaginatedProductResponse;
import com.miguelluque.apifirst.dto.ProductoCreateDto;
import com.miguelluque.apifirst.dto.ProductoDto;

public interface ManageProductUseCase {

    //TODO:
    PaginatedProductResponse getProductsByFilter();

    PaginatedProductResponse getProductList(Integer page, Integer size);

    ProductoDto getProductById(Long id);

    ProductoDto createProduct(ProductoCreateDto producto);

    ProductoDto updateProduct(Long id, ProductoDto productoDto);

    void deleteProduct(Long id);
}
