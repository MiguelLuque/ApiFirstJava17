package com.miguelluque.application.mapper;

import com.miguelluque.domain.dto.ProductoDto;
import com.miguelluque.domain.entity.Producto;

//@Mapper(componentModel = "spring")
public interface ProductMapper {

//    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Producto dtoToProduct(ProductoDto productDto);

    ProductoDto productToDto(Producto product);
}

