package presentation.dtos;

import business.entities.ClienteEntity;
import business.entities.EmpresaEntity;
import business.entities.ProdutoEntity;

import java.util.List;

public class VendaDTO {

    private Integer código;
    private List<ProdutoEntity> itens;
    private Double valor;
    private Double comissaoSistema;
    private EmpresaEntity empresaEntity;
    private ClienteEntity clienteEntity;

    public VendaDTO(Integer código, List<ProdutoEntity> itens, Double valor, Double comissaoSistema, EmpresaEntity empresaEntity, ClienteEntity clienteEntity) {
        this.código = código;
        this.itens = itens;
        this.valor = valor;
        this.comissaoSistema = comissaoSistema;
        this.empresaEntity = empresaEntity;
        this.clienteEntity = clienteEntity;
    }

    public Integer getCódigo() {
        return código;
    }

    public void setCódigo(Integer código) {
        this.código = código;
    }

    public List<ProdutoEntity> getItens() {
        return itens;
    }

    public void setItens(List<ProdutoEntity> itens) {
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

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }
}
