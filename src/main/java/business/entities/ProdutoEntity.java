package business.entities;

import presentation.dtos.ProdutoDTO;

public class ProdutoEntity {
	private Integer id;
	private String nome;
	private Integer quantidade;
	private Double preco;
	private EmpresaEntity empresaEntity;

	public ProdutoEntity(Integer id, String nome, Integer quantidade, Double preco, EmpresaEntity empresaEntity) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.empresaEntity = empresaEntity;
	}

	public ProdutoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EmpresaEntity getEmpresa() {
		return empresaEntity;
	}

	public void setEmpresa(EmpresaEntity empresaEntity) {
		this.empresaEntity = empresaEntity;
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

}
