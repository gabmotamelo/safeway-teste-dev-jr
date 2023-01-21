package builder;

import lombok.Builder;
import presentation.dtos.ClienteDTO;

@Builder
public class ClienteDTOBuilder {

    @Builder.Default
    private String cpf = "333.333.333.33";
    @Builder.Default
    private String nome = "Gabriel Mota";
    @Builder.Default
    private String username = "gabmota";
    @Builder.Default
    private Integer idade = 23;

    public ClienteDTO toClienteDTO() {
        return new ClienteDTO(cpf,nome,username,idade);
    }
}
