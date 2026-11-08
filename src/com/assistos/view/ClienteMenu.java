package com.assistos.view;

import com.assistos.model.Cliente;
import com.assistos.repository.ClienteRepository;

import java.util.List;
import java.util.Scanner;

public class ClienteMenu {
    private final ClienteRepository clienteRepository = new ClienteRepository();

    public void menuCliente() {
        System.out.println("====== Bem Vindo ao AssistOS ======");
        Scanner sc = new Scanner(System.in);
        while (true) {

        System.out.println("1. Cadastrar Cliente ");
        System.out.println("2. Listar Clientes ");
        System.out.println("3. Excluir Cliente ");
        System.out.println("4. Atualizar Dados do Cliente ");
        System.out.println("5. Buscar Cliente por ID ");
        System.out.println("0. Sair ");
        System.out.println("Escolha uma das opções acima: ");

        if (!sc.hasNextLine()) {
            return;
        }
        String opcao = sc.nextLine().trim();

        switch (opcao) {
            // Cadastrar novo cliente
            case "1":

                System.out.println("Digite o nome do cliente: ");
                String nome = sc.nextLine();
                if (nome.isBlank() || nome == null) {
                    throw new IllegalArgumentException("Por favor preencha esse campo!");
                }

                // cpf
                System.out.println("Digite o cpf do cliente: ");
                String cpf = sc.nextLine();
                if (cpf.isBlank() || cpf == null) {
                    throw new IllegalArgumentException("Por favor preencha esse campo!");
                } else if (!cpf.matches("^[0-9]{11}$")) {
                    System.out.println("Erro: o CPF deve conter exatamente 11 digitos, sem pontos ou traços!");
                    return;
                }

                // tel
                System.out.println("Digite o telefone do cliente: ");
                String telefone = sc.nextLine();
                if (telefone.isBlank() || telefone == null) {
                    throw new IllegalArgumentException("Por favor preencha esse campo!");
                }else if (!telefone.matches("^[0-9]{11}$")) {
                    System.out.println("Erro: o CPF deve conter exatamente 11 digitos, sem pontos ou traços!");
                }

                // email
                System.out.println("Digite o email do cliente: ");
                String email = sc.nextLine();

                // rg
                System.out.println("Digite o rg do cliente: ");
                String rg = sc.nextLine();
                if (rg.isBlank() || rg == null) {
                    throw new IllegalArgumentException("Por favor preencha esse campo!");
                }else if (!rg.matches("^[0-9]{9}$")) {
                    System.out.println("Erro: o RG deve conter exatamente 9 digitos, sem pontos ou traços!");
                }


                // ID
                System.out.println("Digite o ID do cliente: ");
                String id = sc.nextLine().trim();
                if (id.isEmpty() || clienteRepository.buscarPorId(id) != null) {
                    System.out.println("ID vazio ou já cadastrado.");
                    break;
                }

                Cliente cliente = new Cliente(nome, cpf, telefone, email, rg, id);

                clienteRepository.salvar(cliente);

                System.out.println("Cliente cadastrado com sucesso!");
                break;

            // Listar clientes
            case "2": System.out.println("====== Listar clientes ======");
               List<Cliente> clientes = clienteRepository.listar();
               for (Cliente cadastrado : clientes) {
                   clienteRepository.listarDados(cadastrado);
                   System.out.println("==============================");
               }
               break;

            // Excluir cliente
            case "3":

                System.out.println("Digite o ID do cliente que deseja excluir: ");
                String idExcluir = sc.nextLine();

                clienteRepository.excluir(idExcluir);

                System.out.println("Cliente excluído com sucesso!" );
                System.out.println("==============================" );
                break;

            // Atualizar dados do cliente
            case "4":
                atualizarCliente(sc);
                break;
            // Buscar cliente
            case "5":
                System.out.println("Digite o ID do cliente: ");
                String idCliente = sc.nextLine().trim();
                Cliente clienteEncontrado = clienteRepository.buscarPorId(idCliente);

                if (clienteEncontrado != null) {
                    clienteRepository.listarDados(clienteEncontrado);
                    System.out.println("==============================");
                }else {
                    System.out.println("Cliente não encontrado!");
                    System.out.println("==============================");
                }
                break;

            // Sair/enecerrar programa
            case "0":
                System.out.println("Saindo...");
                return;

            default:
                System.out.println("Opção inválida.");

        }
        }

    }

    private void atualizarCliente(Scanner sc) {
        System.out.println("Digite o ID do cliente que deseja atualizar: ");
        String id = sc.nextLine().trim();
        Cliente cadastrado = clienteRepository.buscarPorId(id);
        if (cadastrado == null) {
            System.out.println("Cliente não encontrado.");
            System.out.println("==============================");
            return;
        }

        System.out.println("Deixe em branco para manter o valor atual.");
        String nome = lerNovoValor(sc, "Nome", cadastrado.getNome());
        String cpf = lerNovoValor(sc, "CPF", cadastrado.getCpf());
        String telefone = lerNovoValor(sc, "Telefone", cadastrado.getTelefone());
        String email = lerNovoValor(sc, "Email", cadastrado.getEmail());
        String rg = lerNovoValor(sc, "RG", cadastrado.getRg());

        Cliente atualizado = new Cliente(nome, cpf, telefone, email, rg, id);
        if (clienteRepository.atualizar(atualizado)) {
            System.out.println("Cliente atualizado com sucesso!");
            System.out.println("==============================");
        } else {
            System.out.println("Cliente não encontrado.");
            System.out.println("==============================");
        }
    }

    private String lerNovoValor(Scanner sc, String campo, String valorAtual) {
        System.out.println(campo + " (atual: " + valorAtual + "): ");
        String novoValor = sc.nextLine().trim();
        return novoValor.isEmpty() ? valorAtual : novoValor;
    }

}
