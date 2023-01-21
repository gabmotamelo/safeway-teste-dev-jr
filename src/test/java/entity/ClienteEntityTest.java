package entity;


import builder.ClienteDTOBuilder;
import business.entities.ClienteEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import presentation.dtos.ClienteDTO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class ClienteEntityTest {

    @InjectMocks
    ClienteEntity clienteEntity;

    @Test
    void quandoClienteForInstanciadoEPreenchidoEntaoDeveSerCriado(){

        ClienteDTO expectedClienteDTO = ClienteDTOBuilder.builder().build().toClienteDTO();
        ClienteEntity expectedClienteSalvo = clienteEntity(expectedClienteDTO.getCpf(),
                expectedClienteDTO.getNome(),
                expectedClienteDTO.getUsername(),
                expectedClienteDTO.getIdade());

        assertThat(expectedClienteDTO.getNome(), is(equalTo(expectedClienteSalvo.getNome())));
        assertThat(expectedClienteDTO.getCpf(), is(equalTo(expectedClienteSalvo.getCpf())));
        assertThat(expectedClienteDTO.getUsername(), is(equalTo(expectedClienteSalvo.getUsername())));
        assertThat(expectedClienteDTO.getIdade(), is(equalTo(expectedClienteSalvo.getIdade())));

    }

}
