package Dags.dags.service;

import Dags.dags.domain.Client;
import Dags.dags.domain.Products;
import Dags.dags.repository.ClientRepository;
import Dags.dags.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DagsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }

    public Optional<Products> getProduct(Long id) {
        return productsRepository.findById(id);
    }

    public Products saveProduct(final Products product) {
        return productsRepository.save(product);
    }

    public void deleteProduct(final Long id) {
        productsRepository.deleteById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    public Client saveClient(final Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(final Long id) {
        clientRepository.deleteById(id);
    }
}
