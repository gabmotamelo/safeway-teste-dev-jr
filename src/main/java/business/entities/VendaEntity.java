package business.entities;

import java.util.List;

public class VendaEntity {
	private Integer código;
	private List<ProdutoEntity> itens;
	private Double valor;
	private Double comissaoSistema;
	private EmpresaEntity empresaEntity;
	private ClienteEntity clienteEntity;

	public VendaEntity(Integer código, List<ProdutoEntity> itens, Double valor, Double comissaoSistema, EmpresaEntity empresaEntity, ClienteEntity clienteEntity) {
		super();
		this.código = código;
		this.itens = itens;
		this.valor = valor;
		this.comissaoSistema = comissaoSistema;
		this.empresaEntity = empresaEntity;
		this.clienteEntity = clienteEntity;
	}

	public VendaEntity() {
		super();
	}

	public Integer getCódigo() {
		return código;
	}
	
	

	public EmpresaEntity getEmpresa() {
		return empresaEntity;
	}

	public void setEmpresa(EmpresaEntity empresaEntity) {
		this.empresaEntity = empresaEntity;
	}

	public ClienteEntity getCliente() {
		return clienteEntity;
	}

	public void setCliente(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
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

}
