package Dags.dags.repository;

import Dags.dags.domain.Client;
import Dags.dags.domain.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends CrudRepository <Client, Long> {

    @Override
    List<Client> findAll();

    @Override
    Optional<Client> findById(Long id);

    @Override
    Client save(Client save);

}
