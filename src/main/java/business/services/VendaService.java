package business.services;

import business.entities.ClienteEntity;
import business.entities.EmpresaEntity;
import business.entities.ProdutoEntity;
import business.entities.VendaEntity;
import presentation.dtos.VendaDTO;

import java.util.List;

public class VendaService {

//    public static VendaEntity criarVenda(List<ProdutoEntity> carrinho, EmpresaEntity empresaEntity, ClienteEntity clienteEntity, List<VendaEntity> vendaEntities) {
//        Double total = carrinho.stream().mapToDouble(ProdutoEntity::getPreco).sum();
//        Double comissaoSistema = total * empresaEntity.getTaxa();
//        int idVenda = vendaEntities.isEmpty() ? 1 : vendaEntities.get(vendaEntities.size() - 1).getCódigo() + 1;
//        VendaEntity vendaEntity = new VendaEntity(idVenda, carrinho.stream().toList(), total, comissaoSistema, empresaEntity, clienteEntity);
//        empresaEntity.setSaldo(empresaEntity.getSaldo() + total);
//        vendaEntities.add(vendaEntity);
//        return vendaEntity;
//    }

    public static VendaDTO criarVenda(List<ProdutoEntity> carrinho, EmpresaEntity empresaEntity, ClienteEntity clienteEntity, List<VendaDTO> vendasDTOS) {
        Double total = carrinho.stream().mapToDouble(ProdutoEntity::getPreco).sum();
        Double comissaoSistema = total * empresaEntity.getTaxa();
        int idVenda = vendasDTOS.isEmpty() ? 1 : vendasDTOS.get(vendasDTOS.size() - 1).getCódigo() + 1;
        VendaDTO vendaDTO = new VendaDTO(idVenda, carrinho.stream().toList(), total, comissaoSistema, empresaEntity, clienteEntity);
        empresaEntity.setSaldo(empresaEntity.getSaldo() + total);
        vendasDTOS.add(vendaDTO);
        return vendaDTO;
    }

}
