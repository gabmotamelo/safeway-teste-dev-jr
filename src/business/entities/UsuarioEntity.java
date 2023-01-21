package business.entities;

public class UsuarioEntity {
	private String username;
	private String senha;
	private ClienteEntity clienteEntity;
	private EmpresaEntity empresaEntity;

	public UsuarioEntity() {
		super();
	}

	public UsuarioEntity(String username, String senha, ClienteEntity clienteEntity, EmpresaEntity empresaEntity) {
		super();
		this.username = username;
		this.senha = senha;
		this.clienteEntity = clienteEntity;
		this.empresaEntity = empresaEntity;
	}

	public boolean IsAdmin() {
		return this.empresaEntity == null && this.clienteEntity == null;
	}

	public boolean IsEmpresa() {
		return this.empresaEntity != null;
	}

	public boolean IsCliente() {
		return this.clienteEntity != null;
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

	public ClienteEntity getCliente() {
		return clienteEntity;
	}

	public void setCliente(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}

	public EmpresaEntity getEmpresa() {
		return empresaEntity;
	}

	public void setEmpresa(EmpresaEntity empresaEntity) {
		this.empresaEntity = empresaEntity;
	}

}
