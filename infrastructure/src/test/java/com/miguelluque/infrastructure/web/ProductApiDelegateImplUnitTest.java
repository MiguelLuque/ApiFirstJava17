package com.miguelluque.infrastructure.web;

import com.miguelluque.domain.dto.ProductoDto;
import com.miguelluque.domain.usecase.ManageProductUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductApiDelegateImplUnitTest {

    @Mock
    private ManageProductUseCase manageProductUseCase;

    @InjectMocks
    private ProductApiDelegateImpl productApiDelegateImpl;


    @Test
    void testCreateProduct() {
        ProductoDto mockProductoDto = new ProductoDto();
        mockProductoDto.setId(1L);

        when(manageProductUseCase.createProduct(any(ProductoDto.class))).thenReturn(mockProductoDto);

        ResponseEntity<ProductoDto> response = productApiDelegateImpl.createProduct(new ProductoDto());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
