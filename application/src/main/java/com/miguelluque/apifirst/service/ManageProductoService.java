package com.miguelluque.apifirst.service;


import com.miguelluque.apifirst.dto.PaginatedProductResponse;
import com.miguelluque.apifirst.dto.ProductoCreateDto;
import com.miguelluque.apifirst.dto.ProductoDto;
import com.miguelluque.apifirst.entity.Producto;
import com.miguelluque.apifirst.mapper.ProductMapper;
import com.miguelluque.apifirst.repository.ProductRepository;
import com.miguelluque.apifirst.usecase.ManageProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManageProductoService implements ManageProductUseCase {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;


    @Override
    public PaginatedProductResponse getProductList(Integer page, Integer size) {

        Pageable pageParams = PageRequest.of(page, size, Sort.by("nombre").ascending());

        Page<Producto> res = productRepository.findAll(pageParams);
        return productMapper.toPaginatedResponse(res, page);

    }

    @Override
    public PaginatedProductResponse getProductsByFilter() {
        return null;
    }

    @Override
    public ProductoDto createProduct(ProductoCreateDto producto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(producto)));
    }

    @Override
    public ProductoDto getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto).orElseThrow(() -> new NoSuchElementException("Product not found"));
    }

    @Override
    public ProductoDto updateProduct(Long id, ProductoCreateDto producto) {
        //check if exist, if not, throw an error
        this.getProductById(id);
        Producto productEntity = productMapper.toEntity(producto);
        productEntity.setId(id);

        return productMapper.toDto(productRepository.save(productEntity));
    }

    @Override
    public void deleteProduct(Long id) {
        this.getProductById(id);
        productRepository.deleteById(id);
    }
}


