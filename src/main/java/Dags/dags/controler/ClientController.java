package Dags.dags.controler;

import Dags.dags.domain.ClientDto;
import Dags.dags.mapper.ClientMapper;
import Dags.dags.service.DagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dags/")
public class ClientController {

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private DagsService service;

    @RequestMapping(method = RequestMethod.GET, value = "getClients")
    public List<ClientDto> getClients() {
        return clientMapper.mapClientToDtoListClient(service.getAllClients());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getClient")
    public ClientDto getClient(@RequestParam Long clientId) throws ClientNotFoundException {
        return clientMapper.mapToClientDto(service.getClient(clientId).orElseThrow(ClientNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteClient")
    public void deleteClient(@RequestParam Long clientId) {
        service.deleteClient(clientId);

    }

    @RequestMapping(method = RequestMethod.POST, value = "createClient", consumes = APPLICATION_JSON_VALUE)
    public void createClient(@RequestBody ClientDto clientDto) {
        service.saveClient(clientMapper.mapToClient(clientDto));
    }

}
