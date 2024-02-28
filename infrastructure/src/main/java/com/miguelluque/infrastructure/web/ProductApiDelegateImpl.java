package com.miguelluque.infrastructure.web;

import com.miguelluque.domain.api.ProductosApiDelegate;
import com.miguelluque.domain.dto.PaginatedProductResponse;
import com.miguelluque.domain.dto.ProductoDto;
import com.miguelluque.domain.usecase.ManageProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductApiDelegateImpl implements ProductosApiDelegate {

    private final ManageProductUseCase manageProductUseCase;

    @Override
    public ResponseEntity<PaginatedProductResponse> getProductList(Integer page, Integer size) {
        return ResponseEntity.ok(manageProductUseCase.getProductList(page, size));
    }

    @Override
    public ResponseEntity<ProductoDto> getProductById(Long id) {
        return ResponseEntity.ok(manageProductUseCase.getProductById(id));
    }

    @Override
    public ResponseEntity<ProductoDto> createProduct(ProductoDto productoDto) {
        return new ResponseEntity<>(manageProductUseCase.createProduct(productoDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductoDto> updateProduct(Long id, ProductoDto productoDto) {
        return ResponseEntity.ok(manageProductUseCase.updateProduct(id, productoDto));
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long id) {
        manageProductUseCase.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
