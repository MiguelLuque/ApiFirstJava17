package com.miguelluque.apifirst.web;

import com.miguelluque.apifirst.dto.ProductoCreateDto;
import com.miguelluque.apifirst.dto.ProductoDto;
import com.miguelluque.apifirst.usecase.ManageProductUseCase;
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
public class ProductApiControllerImplUnitTest {

    @Mock
    private ManageProductUseCase manageProductUseCase;

    @InjectMocks
    private ProductApiControllerImpl productApiControllerImpl;


    @Test
    void testCreateProduct() {
        ProductoDto mockProductoDto = new ProductoDto();
        mockProductoDto.setId(1L);

        when(manageProductUseCase.createProduct(any(ProductoCreateDto.class))).thenReturn(mockProductoDto);

        ResponseEntity<ProductoDto> response = productApiControllerImpl.createProduct(new ProductoCreateDto());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

}
