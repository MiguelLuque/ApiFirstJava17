package com.miguelluque.apifirst.service;

import com.miguelluque.apifirst.dto.PaginatedProductResponse;
import com.miguelluque.apifirst.dto.ProductoCreateDto;
import com.miguelluque.apifirst.dto.ProductoDto;
import com.miguelluque.apifirst.entity.Producto;
import com.miguelluque.apifirst.mapper.ProductMapper;
import com.miguelluque.apifirst.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManageProductServiceUnitTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ManageProductoService manageProductoService;

    private Producto producto;
    private ProductoDto productoDto;

    @BeforeEach
    void setUp() {
        producto = new Producto(1L, "Producto", "Descripcion", 100.0);
        productoDto = new ProductoDto();
        productoDto.setId(1L);
        productoDto.setNombre("Producto");
        productoDto.setDescripcion("Descripcion");
        productoDto.setPrecio(100.0);
        productoDto.setImpuesto(21.0);
        productoDto.setPrecioConImpuesto(121.0);
    }

    @Test
    void getProductListOk() {
        Page<Producto> page = new PageImpl<>(List.of(producto));
        when(productRepository.findAll(any(PageRequest.class))).thenReturn(page);
        when(productMapper.toPaginatedResponse(any(Page.class), anyInt())).thenReturn(new PaginatedProductResponse());

        PaginatedProductResponse response = manageProductoService.getProductList(0, 10);

        assertNotNull(response);
        verify(productRepository).findAll(any(PageRequest.class));
        verify(productMapper).toPaginatedResponse(any(Page.class), anyInt());
    }

    @Test
    void getProductsByFilterOk() {
        Page<Producto> page = new PageImpl<>(List.of(producto));
        when(productRepository.findAll(any(), any(PageRequest.class))).thenReturn(page);
        when(productMapper.toPaginatedResponse(any(Page.class), anyInt())).thenReturn(new PaginatedProductResponse());

        PaginatedProductResponse response = manageProductoService.getProductsByFilter("Producto", null, null, null, 0, 10);

        assertNotNull(response);
        verify(productRepository).findAll(any(), any(PageRequest.class));
        verify(productMapper).toPaginatedResponse(any(Page.class), anyInt());
    }

    @Test
    void createProductOK() {
        when(productRepository.save(any(Producto.class))).thenReturn(producto);
        when(productMapper.toDto(any(Producto.class))).thenReturn(productoDto);

        ProductoDto result = manageProductoService.createProduct(new ProductoCreateDto());

        assertNotNull(result);
        assertEquals(productoDto.getNombre(), result.getNombre());
        verify(productRepository).save(any(Producto.class));
        verify(productMapper).toDto(any(Producto.class));
    }

    @Test
    void getProductByIdNotFound() {
        when(productRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> manageProductoService.getProductById(anyLong()));

        verify(productRepository).findById(anyLong());
    }

}
