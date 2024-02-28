package com.miguelluque.application.service;


import com.miguelluque.domain.dto.PaginatedProductResponse;
import com.miguelluque.domain.dto.ProductoDto;
import com.miguelluque.domain.repository.ProductRepository;
import com.miguelluque.domain.usecase.ManageProductUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ManageProductoService implements ManageProductUseCase {

    private final ProductRepository productRepository;

    @Autowired
    public ManageProductoService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductoDto createProduct(ProductoDto producto) {
        // Implementación específica, por ejemplo, validar el producto antes de guardarlo
        return null;
    }

    @Override
    public ProductoDto getProductById(Long id) {
        return null;
    }

    @Override
    public PaginatedProductResponse getProductList(Integer page, Integer size) {
        return null;
    }

    @Override
    public PaginatedProductResponse getProductsByFilter() {
        return null;
    }

    @Override
    public ProductoDto updateProduct(Long id, ProductoDto producto) {
        // Asegúrate de que el producto existe antes de actualizar
        producto.setId(id);
//        return productRepository.save(producto);
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
