package Dags.dags.controler;


import Dags.dags.domain.ProductsDto;
import Dags.dags.mapper.ProductsMapper;
import Dags.dags.service.DagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dags/")
public class DagsController {

    @Autowired
    private DagsService service;

    @Autowired
    private ProductsMapper productsMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductsDto> getProducts() {
        return productsMapper.mapProductDtoListToList(service.getAllProducts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductsDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return productsMapper.mapToProductsDto(service.getProduct(productId)
                .orElseThrow(ProductNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        service.deleteProduct(productId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductsDto productsDto) {
        service.saveProduct(productsMapper.mapToProducts(productsDto));
    }

}
