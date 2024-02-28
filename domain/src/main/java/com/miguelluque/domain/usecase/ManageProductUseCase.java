package com.miguelluque.domain.usecase;

import com.miguelluque.domain.dto.PaginatedProductResponse;
import com.miguelluque.domain.dto.ProductoDto;

public interface ManageProductUseCase {

    //TODO:
    PaginatedProductResponse getProductsByFilter();

    PaginatedProductResponse getProductList(Integer page, Integer size);

    ProductoDto getProductById(Long id);

    ProductoDto createProduct(ProductoDto producto);

    ProductoDto updateProduct(Long id, ProductoDto productoDto);

    void deleteProduct(Long id);
}
