package presentation.dtos;

import business.entities.EmpresaEntity;

public class ProdutoDTO {

    private Integer id;
    private String nome;
    private Integer quantidade;
    private Double preco;
    private EmpresaEntity empresaEntity;

    public ProdutoDTO(Integer id, String nome, Integer quantidade, Double preco, EmpresaEntity empresaEntity) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.empresaEntity = empresaEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public EmpresaEntity getEmpresaEntity() {
        return empresaEntity;
    }

    public void setEmpresaEntity(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }
}
