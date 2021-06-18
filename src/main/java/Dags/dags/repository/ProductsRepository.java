package Dags.dags.repository;

import Dags.dags.domain.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends CrudRepository<Products, Long> {

    @Override
    List<Products> findAll();

    @Override
    Optional<Products> findById(Long id);

    @Override
    Products save(Products save);

}
