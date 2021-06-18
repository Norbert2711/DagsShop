package Dags.dags.mapper;

import Dags.dags.domain.Client;
import Dags.dags.domain.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

    @Autowired
    private ProductsMapper productsMapper;

    public Client mapToClient(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getName()

        );

    }

    public ClientDto mapToClientDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getName()
        );
    }

    public List<ClientDto> mapClientToDtoListClient(final List<Client> clientList) {
        return clientList.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }

}
