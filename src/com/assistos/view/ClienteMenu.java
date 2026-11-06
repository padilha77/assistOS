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
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1. Cadastrar Cliente ");
        System.out.println("2. Listar Clientes ");
        System.out.println("3. Excluir Cliente ");
        System.out.println("4. Atualizar Dados do Cliente ");
        System.out.println("5. Buscar Cliente ");
        System.out.println("0. Sair ");

        if (!sc.hasNextLine()) {
            return;
        }
        String opcao = sc.nextLine().trim();

        switch (opcao) {
            // Cadastrar novo cliente
            case "1":
                System.out.println("Digite o nome do cliente: ");
                String nome = sc.nextLine();

                System.out.println("Digite o cpf do cliente: ");
                String cpf = sc.nextLine();

                System.out.println("Digite o telefone do cliente: ");
                String telefone = sc.nextLine();

                System.out.println("Digite o email do cliente: ");
                String email = sc.nextLine();

                System.out.println("Digite o rg do cliente: ");
                String rg = sc.nextLine();

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
            case "2":
               List<Cliente> clientes = clienteRepository.listar();
               for (Cliente cadastrado : clientes) {
                   clienteRepository.listarDados(cadastrado);
               }
               break;

            // Excluir cliente
            case "3":
                System.out.println("Digite o nome do cliente: ");
                String nomeExcluir = sc.nextLine();

                System.out.println("Digite o cpf do cliente: ");
                String cpfExcluir = sc.nextLine();

                System.out.println("Digite o telefone do cliente: ");
                String telefoneExcluir = sc.nextLine();

                System.out.println("Digite o email do cliente: ");
                String emailExluir = sc.nextLine();

                System.out.println("Digite o rg do cliente: ");
                String rgExcluir = sc.nextLine();

                String idExcluir = sc.nextLine();

                Cliente clienteExcluir = new Cliente(nomeExcluir, cpfExcluir, telefoneExcluir, emailExluir, rgExcluir, idExcluir);

                clienteRepository.excluir(clienteExcluir);

                System.out.println("Cliente excluído com sucesso!" );
                break;

            // Atualizar dados do cliente
            case "4":
                atualizarCliente(sc);
                break;
            // Buscar cliente
            case "5":
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
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private String lerNovoValor(Scanner sc, String campo, String valorAtual) {
        System.out.println(campo + " (atual: " + valorAtual + "): ");
        String novoValor = sc.nextLine().trim();
        return novoValor.isEmpty() ? valorAtual : novoValor;
    }

}
