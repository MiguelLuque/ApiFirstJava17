package com.miguelluque.apifirst.mapper;

import com.miguelluque.apifirst.dto.PaginatedProductResponse;
import com.miguelluque.apifirst.dto.ProductoCreateDto;
import com.miguelluque.apifirst.dto.ProductoDto;
import com.miguelluque.apifirst.entity.Producto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    Producto toEntity(ProductoDto productDto);

    Producto toEntity(ProductoCreateDto productDto);

    ProductoDto toDto(Producto product);

    List<ProductoDto> toDto(List<Producto> target);

    default PaginatedProductResponse toPaginatedResponse(Page<Producto> src, Integer page) {
        PaginatedProductResponse res = new PaginatedProductResponse();
        res.setProducts(this.toDto(src.getContent()));
        res.setCurrentPage(page);
        res.setTotalPages(src.getTotalPages());
        return res;
    }
}

