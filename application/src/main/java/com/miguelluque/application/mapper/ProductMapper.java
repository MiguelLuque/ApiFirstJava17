package com.miguelluque.application.mapper;

import com.miguelluque.domain.dto.PaginatedProductResponse;
import com.miguelluque.domain.dto.ProductoDto;
import com.miguelluque.domain.entity.Producto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    Producto toEntity(ProductoDto productDto);

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

