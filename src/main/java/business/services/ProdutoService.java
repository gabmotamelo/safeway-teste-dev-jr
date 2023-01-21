package business.services;

import business.entities.ClienteEntity;
import business.entities.EmpresaEntity;
import presentation.dtos.ProdutoDTO;
import presentation.dtos.VendaDTO;

import java.util.List;

public class ProdutoService {

    public ProdutoDTO criarProduto(Integer idProduto, String nomeProduto, Integer quantidadeProduto, Double precoProduto, EmpresaEntity empresaEntityProduto ) {
         return new ProdutoDTO(idProduto,nomeProduto, quantidadeProduto, precoProduto,empresaEntityProduto);
    }
}
