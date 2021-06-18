package Dags.dags.service;

import Dags.dags.domain.Products;
import Dags.dags.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DagsService {

    @Autowired
    private ProductsRepository reposiroty;

    public List<Products> getAllProducts() {
        return reposiroty.findAll();
    }

    public Optional<Products> getProduct(Long id) {
        return reposiroty.findById(id);
    }

    public Products saveProduct(final Products product) {
        return reposiroty.save(product);
    }

    public void deleteProduct(final Long id) {
        reposiroty.deleteById(id);
    }

}
