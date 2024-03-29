package com.miguelluque.apifirst.mapper;

import com.miguelluque.apifirst.dto.PaginatedProductResponse;
import com.miguelluque.apifirst.dto.ProductoDto;
import com.miguelluque.apifirst.entity.Producto;
import com.miguelluque.apifirst.tax.CalculadorDeImpuestosIVA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductMapperUnitTest {


    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);


    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(this.productMapper, "calculadorDeImpuestos", new CalculadorDeImpuestosIVA());
    }


    @Test
    void shouldMapProductToDto() {
        Producto product = Producto.builder()
                .id(1L)
                .nombre("name")
                .descripcion("description")
                .precio(10.0)
                .build();

        ProductoDto productDto = productMapper.toDto(product);

        assertEquals(product.getId(), productDto.getId());
        assertEquals(product.getNombre(), productDto.getNombre());
        assertEquals(product.getDescripcion(), productDto.getDescripcion());
        assertEquals(product.getPrecio(), productDto.getPrecio());
        assertEquals(product.getPrecio() * 1.21, productDto.getPrecioConImpuesto());
        assertEquals(product.getPrecio() * 0.21, productDto.getImpuesto());
    }

    @Test
    void shouldMapDtoToProduct() {
        ProductoDto productDto = new ProductoDto();
        productDto.setId(2L);
        productDto.setNombre("Otro Test Product");
        productDto.setDescripcion("Otra Descripción de Test");
        productDto.setPrecio(200.0);

        Producto product = productMapper.toEntity(productDto);

        assertEquals(productDto.getId(), product.getId());
        assertEquals(productDto.getNombre(), product.getNombre());
        assertEquals(productDto.getDescripcion(), product.getDescripcion());
        assertEquals(productDto.getPrecio(), product.getPrecio());
    }

    @Test
    void shouldMapDtoToPaginatedProductResponse() {
        Producto product = Producto.builder()
                .id(1L)
                .nombre("name")
                .descripcion("description")
                .precio(10.0)
                .build();

        final var productos = List.of(product);

        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Producto> productosPage = new PageImpl<>(productos, pageRequest, productos.size());
        PaginatedProductResponse res = productMapper.toPaginatedResponse(productosPage, 0);

        assertEquals(1, res.getProducts().size());
        assertEquals(0, res.getCurrentPage());
        assertEquals(1, res.getTotalPages());

    }
}

