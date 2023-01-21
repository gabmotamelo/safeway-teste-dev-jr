import business.entities.*;
import presentation.dtos.VendaDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static business.services.VendaService.criarVenda;

public class Main {

	public static void main(String[] args) {

		// SIMULANDO BANCO DE DADOS

		List<ProdutoEntity> carrinho = new ArrayList<ProdutoEntity>();
		List<VendaDTO> vendasDTOList = new ArrayList<VendaDTO>();

		EmpresaEntity empresaEntity = new EmpresaEntity(2, "SafeWay Padaria", "30021423000159", 0.15, 0.0);
		EmpresaEntity empresaEntity2 = new EmpresaEntity(1, "Level Varejo", "53239160000154", 0.05, 0.0);
		EmpresaEntity empresaEntity3 = new EmpresaEntity(3, "SafeWay Restaurante", "41361511000116", 0.20, 0.0);

		ProdutoEntity produtoEntity = new ProdutoEntity(1, "Pão Frances", 5, 3.50, empresaEntity);
		ProdutoEntity produtoEntity2 = new ProdutoEntity(2, "Coturno", 10, 400.0, empresaEntity2);
		ProdutoEntity produtoEntity3 = new ProdutoEntity(3, "Jaqueta Jeans", 15, 150.0, empresaEntity2);
		ProdutoEntity produtoEntity4 = new ProdutoEntity(4, "Calça Sarja", 15, 150.0, empresaEntity2);
		ProdutoEntity produtoEntity5 = new ProdutoEntity(5, "Prato feito - Frango", 10, 25.0, empresaEntity3);
		ProdutoEntity produtoEntity6 = new ProdutoEntity(6, "Prato feito - Carne", 10, 25.0, empresaEntity3);
		ProdutoEntity produtoEntity7 = new ProdutoEntity(7, "Suco Natural", 30, 10.0, empresaEntity3);
		ProdutoEntity produtoEntity8 = new ProdutoEntity(8, "Sonho", 5, 8.50, empresaEntity);
		ProdutoEntity produtoEntity9 = new ProdutoEntity(9, "Croissant", 7, 6.50, empresaEntity);
		ProdutoEntity produtoEntity10 = new ProdutoEntity(10, "Ché Gelado", 4, 5.50, empresaEntity);

		ClienteEntity clienteEntity = new ClienteEntity("07221134049", "Allan da Silva", "cliente", 20);
		ClienteEntity clienteEntity2 = new ClienteEntity("72840700050", "Samuel da Silva", "cliente2", 24);

		UsuarioEntity usuarioEntity1 = new UsuarioEntity("admin", "1234", null, null);
		UsuarioEntity usuarioEntity2 = new UsuarioEntity("empresa", "1234", null, empresaEntity);
		UsuarioEntity usuarioEntity3 = new UsuarioEntity("cliente", "1234", clienteEntity, null);
		UsuarioEntity usuarioEntity4 = new UsuarioEntity("cliente2", "1234", clienteEntity2, null);
		UsuarioEntity usuarioEntity5 = new UsuarioEntity("empresa2", "1234", null, empresaEntity2);
		UsuarioEntity usuarioEntity6 = new UsuarioEntity("empresa3", "1234", null, empresaEntity3);


		List<UsuarioEntity> usuarioEntities = Arrays.asList(usuarioEntity1, usuarioEntity2, usuarioEntity3, usuarioEntity4, usuarioEntity5, usuarioEntity6);
		List<ClienteEntity> clienteEntities = Arrays.asList(clienteEntity, clienteEntity2);
		List<EmpresaEntity> empresaEntities = Arrays.asList(empresaEntity, empresaEntity2, empresaEntity3);
		List<ProdutoEntity> produtoEntities = Arrays.asList(produtoEntity, produtoEntity2, produtoEntity3, produtoEntity4, produtoEntity5, produtoEntity6, produtoEntity7,
				produtoEntity8, produtoEntity9, produtoEntity10);

		executar(usuarioEntities, clienteEntities, empresaEntities, produtoEntities, carrinho, vendasDTOList);
	}

	public static void executar(List<UsuarioEntity> usuarioEntities, List<ClienteEntity> clienteEntities, List<EmpresaEntity> empresaEntities,
								List<ProdutoEntity> produtoEntities, List<ProdutoEntity> carrinho, List<VendaDTO> vendasDTOList) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com seu usuário e senha:");
		System.out.print("Usuário: ");
		String username = sc.next();
		System.out.print("Senha: ");
		String senha = sc.next();
		

		List<UsuarioEntity> usuariosSearches = usuarioEntities.stream().filter(x -> x.getUsername().equals(username))
				.collect(Collectors.toList());
		if (usuariosSearches.size() > 0) {
			UsuarioEntity usuarioEntityLogado = usuariosSearches.get(0);
			if ((usuarioEntityLogado.getSenha().equals(senha))) {
				System.out.println("Escolha uma opção para iniciar");
				if (usuarioEntityLogado.IsEmpresa()) {
					System.out.println("1 - Listar vendas");
					System.out.println("2 - Ver produtos");
					System.out.println("0 - Deslogar");
					Integer escolha = sc.nextInt();

					switch (escolha) {
					case 1: {
						System.out.println();
						System.out.println("************************************************************");
						System.out.println("VENDAS EFETUADAS");
						vendasDTOList.stream().forEach(vendaDTO -> {
							if (vendaDTO.getEmpresaEntity().getId().equals(usuarioEntityLogado.getEmpresa().getId())) {
								System.out.println("************************************************************");
								System.out.println("business.Venda de código: " + vendaDTO.getCódigo() + " no CPF "
										+ vendaDTO.getClienteEntity().getCpf() + ": ");
								vendaDTO.getItens().stream().forEach(x -> {
									System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
								});
								System.out.println("Total business.Venda: R$" + vendaDTO.getValor());
								System.out.println("Total Taxa a ser paga: R$" + vendaDTO.getComissaoSistema());
								System.out.println("Total Líquido  para empresa"
										+ (vendaDTO.getValor() - vendaDTO.getComissaoSistema()));
								System.out.println("************************************************************");
							}

						});
						System.out.println("Saldo domain.Empresa: " + usuarioEntityLogado.getEmpresa().getSaldo());
						System.out.println("************************************************************");

						executar(usuarioEntities, clienteEntities, empresaEntities, produtoEntities, carrinho, vendasDTOList);
					}
					case 2: {
						System.out.println();
						System.out.println("************************************************************");
						System.out.println("MEUS PRODUTOS");
						produtoEntities.stream().forEach(produtoEntity -> {
							if (produtoEntity.getEmpresa().getId().equals(usuarioEntityLogado.getEmpresa().getId())) {
								System.out.println("************************************************************");
								System.out.println("Código: " + produtoEntity.getId());
								System.out.println("domain.Produto: " + produtoEntity.getNome());
								System.out.println("Quantidade em estoque: " + produtoEntity.getQuantidade());
								System.out.println("Valor: R$" + produtoEntity.getPreco());
								System.out.println("************************************************************");
							}

						});
						System.out.println("Saldo domain.Empresa: " + usuarioEntityLogado.getEmpresa().getSaldo());
						System.out.println("************************************************************");

						executar(usuarioEntities, clienteEntities, empresaEntities, produtoEntities, carrinho, vendasDTOList);
					}
					case 0: {
						executar(usuarioEntities, clienteEntities, empresaEntities, produtoEntities, carrinho, vendasDTOList);

					}
					}

				} else {
					System.out.println("1 - Relizar Compras");
					System.out.println("2 - Ver Compras");
					System.out.println("0 - Deslogar");
					Integer escolha = sc.nextInt();
					switch (escolha) {
					case 1: {
						System.out.println("Para realizar uma compra, escolha a empresa onde deseja comprar: ");
						empresaEntities.stream().forEach(x -> {
							System.out.println(x.getId() + " - " + x.getNome());
						});
						Integer escolhaEmpresa = sc.nextInt();
						Integer escolhaProduto = -1;
						do {
							System.out.println("Escolha os seus produtos: ");
							produtoEntities.stream().forEach(x -> {
								if (x.getEmpresa().getId().equals(escolhaEmpresa)) {
									System.out.println(x.getId() + " - " + x.getNome());
								}
							});
							System.out.println("0 - Finalizar compra");
							escolhaProduto = sc.nextInt();
							for (ProdutoEntity produtoEntitySearch : produtoEntities) {
								if (produtoEntitySearch.getId().equals(escolhaProduto))
									carrinho.add(produtoEntitySearch);
							}
						} while (escolhaProduto != 0);
						System.out.println("************************************************************");
						System.out.println("Resumo da compra: ");
						carrinho.stream().forEach(x -> {
							if (x.getEmpresa().getId().equals(escolhaEmpresa)) {
								System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
							}
						});
						EmpresaEntity empresaEntityEscolhida = empresaEntities.stream().filter(x -> x.getId().equals(escolhaEmpresa))
								.collect(Collectors.toList()).get(0);
						ClienteEntity clienteEntityLogado = clienteEntities.stream()
								.filter(x -> x.getUsername().equals(usuarioEntityLogado.getUsername()))
								.collect(Collectors.toList()).get(0);
						VendaDTO vendaDTO = criarVenda(carrinho, empresaEntityEscolhida, clienteEntityLogado, vendasDTOList);
						System.out.println("Total: R$" + vendaDTO.getValor());
						System.out.println("************************************************************");
						carrinho.clear();
						executar(usuarioEntities, clienteEntities, empresaEntities, produtoEntities, carrinho, vendasDTOList);
					}
					case 2: {
						System.out.println();
						System.out.println("************************************************************");
						System.out.println("COMPRAS EFETUADAS");
						vendasDTOList.stream().forEach(vendaDTO -> {
							if (vendaDTO.getClienteEntity().getUsername().equals(usuarioEntityLogado.getUsername())) {
								System.out.println("************************************************************");
								System.out.println("Compra de código: " + vendaDTO.getCódigo() + " na empresa "
										+ vendaDTO.getEmpresaEntity().getNome() + ": ");
								vendaDTO.getItens().stream().forEach(x -> {
									System.out.println(x.getId() + " - " + x.getNome() + "    R$" + x.getPreco());
								});
								System.out.println("Total: R$" + vendaDTO.getValor());
								System.out.println("************************************************************");
							}

						});

						executar(usuarioEntities, clienteEntities, empresaEntities, produtoEntities, carrinho, vendasDTOList);
					}
					case 0: {
						executar(usuarioEntities, clienteEntities, empresaEntities, produtoEntities, carrinho, vendasDTOList);

					}

					}
				}

			} else
				System.out.println("Senha incorreta");
		} else {
			System.out.println("Usuário não encontrado");
		}
	}


}
