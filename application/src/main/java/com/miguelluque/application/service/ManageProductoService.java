package com.miguelluque.application.service;


import com.miguelluque.application.mapper.ProductMapper;
import com.miguelluque.domain.dto.PaginatedProductResponse;
import com.miguelluque.domain.dto.ProductoDto;
import com.miguelluque.domain.entity.Producto;
import com.miguelluque.domain.repository.ProductRepository;
import com.miguelluque.domain.usecase.ManageProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManageProductoService implements ManageProductUseCase {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Autowired
    public ManageProductoService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public PaginatedProductResponse getProductList(Integer page, Integer size) {

        Pageable pageParams = PageRequest.of(page, size, Sort.by("nombre").descending());

        Page<Producto> res = productRepository.findAll(pageParams);
        return productMapper.toPaginatedResponse(res, page);

    }

    @Override
    public PaginatedProductResponse getProductsByFilter() {
        return null;
    }

    @Override
    public ProductoDto createProduct(ProductoDto producto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(producto)));
    }

    @Override
    public ProductoDto getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDto).orElseThrow(() -> new NoSuchElementException("Product not found"));
    }

    @Override
    public ProductoDto updateProduct(Long id, ProductoDto producto) {
        if (!checkIfExists(id).isPresent()) {
            throw new IllegalArgumentException("Product not found");
        }
        Producto productEntity = productMapper.toEntity(producto);
        productEntity.setId(id);

        return productMapper.toDto(productRepository.save(productEntity));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private Optional<Producto> checkIfExists(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must not be null");
        }
        return productRepository.findById(id);
    }
}


