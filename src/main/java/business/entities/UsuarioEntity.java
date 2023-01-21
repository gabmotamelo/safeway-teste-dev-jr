package business.entities;

import presentation.dtos.ClienteDTO;

public class UsuarioEntity {
	private String username;
	private String senha;
	private ClienteDTO clienteDTO;
	private EmpresaEntity empresaEntity;

	public UsuarioEntity() {
		super();
	}

	public UsuarioEntity(String username, String senha, ClienteDTO clienteDTO, EmpresaEntity empresaEntity) {
		super();
		this.username = username;
		this.senha = senha;
		this.clienteDTO = clienteDTO;
		this.empresaEntity = empresaEntity;
	}

	public boolean IsAdmin() {
		return this.empresaEntity == null && this.clienteDTO == null;
	}

	public boolean IsEmpresa() {
		return this.empresaEntity != null;
	}

	public boolean IsCliente() {
		return this.clienteDTO != null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ClienteDTO getCliente() {
		return clienteDTO;
	}

	public void setCliente(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}

	public EmpresaEntity getEmpresa() {
		return empresaEntity;
	}

	public void setEmpresa(EmpresaEntity empresaEntity) {
		this.empresaEntity = empresaEntity;
	}

}
