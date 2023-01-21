package presentation.dtos;

import business.entities.ClienteEntity;
import business.entities.EmpresaEntity;

import java.util.List;

public class VendaDTO {

    private Integer código;
    private List<ProdutoDTO> itens;
    private Double valor;
    private Double comissaoSistema;
    private EmpresaEntity empresaEntity;
    private ClienteDTO clienteDTO;

    public VendaDTO(Integer código, List<ProdutoDTO> itens, Double valor, Double comissaoSistema, EmpresaEntity empresaEntity, ClienteDTO clienteDTO) {
        this.código = código;
        this.itens = itens;
        this.valor = valor;
        this.comissaoSistema = comissaoSistema;
        this.empresaEntity = empresaEntity;
        this.clienteDTO = clienteDTO;
    }

    public Integer getCódigo() {
        return código;
    }

    public void setCódigo(Integer código) {
        this.código = código;
    }

    public List<ProdutoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ProdutoDTO> itens) {
        this.itens = itens;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getComissaoSistema() {
        return comissaoSistema;
    }

    public void setComissaoSistema(Double comissaoSistema) {
        this.comissaoSistema = comissaoSistema;
    }

    public EmpresaEntity getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }
}
