package business.services;

import business.entities.ClienteEntity;
import business.entities.EmpresaEntity;
import presentation.dtos.ClienteDTO;
import presentation.dtos.ProdutoDTO;
import presentation.dtos.VendaDTO;

import java.util.List;

public class VendaService {

    public static VendaDTO criarVenda(List<ProdutoDTO> carrinho, EmpresaEntity empresaEntity, ClienteDTO clienteDTO, List<VendaDTO> vendasDTOS) {
        Double total = carrinho.stream().mapToDouble(ProdutoDTO::getPreco).sum();
        Double comissaoSistema = total * empresaEntity.getTaxa();
        int idVenda = vendasDTOS.isEmpty() ? 1 : vendasDTOS.get(vendasDTOS.size() - 1).getCódigo() + 1;
        VendaDTO vendaDTO = new VendaDTO(idVenda, carrinho.stream().toList(), total, comissaoSistema, empresaEntity, clienteDTO);
        empresaEntity.setSaldo(empresaEntity.getSaldo() + total);
        vendasDTOS.add(vendaDTO);
        return vendaDTO;
    }

}
