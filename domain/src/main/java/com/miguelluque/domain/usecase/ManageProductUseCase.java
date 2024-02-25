package com.miguelluque.domain.usecase;

import com.miguelluque.domain.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ManageProductUseCase {
    Producto createProduct(Producto producto);

    Optional<Producto> getProductById(Long id);

    List<Producto> getAllProducts();

    List<Producto> getProductsByFilter();

    Producto updateProduct(Long id, Producto producto);

    void deleteProduct(Long id);
}
