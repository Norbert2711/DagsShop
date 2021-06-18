package Dags.dags.mapper;

import Dags.dags.domain.Products;
import Dags.dags.domain.ProductsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsMapper {

    @Autowired
    private ClientMapper clientMapper;

    public Products mapToProducts(final ProductsDto productsDto) {
        return new Products(
                productsDto.getId(),
                productsDto.getName()
        );
    }

    public ProductsDto mapToProductsDto(final Products products) {
        ProductsDto productsDto = new ProductsDto(
                products.getId(),
                products.getName()
        );
        productsDto.setClientDtoList(clientMapper.mapClientToDtoListClient(
                products.getClientList()));
        return productsDto;
    }

    public List<ProductsDto> mapProductDtoListToList(final List<Products> products) {
        return products.stream()
                .map(this::mapToProductsDto)
                .collect(Collectors.toList());
    }

}
