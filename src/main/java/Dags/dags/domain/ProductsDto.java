package Dags.dags.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductsDto {

    private Long id;
    private String name;
    private List<ClientDto> clientDtoList;

    public void setClientDtoList(List<ClientDto> clientDtoList) {
        this.clientDtoList = clientDtoList;
    }

    public ProductsDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
