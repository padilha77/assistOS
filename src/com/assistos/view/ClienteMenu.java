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
        System.out.println("Escolha uma das opções abaixo: ");
        System.out.println("1. Cadastrar Cliente ");
        System.out.println("2. Listar Clientes ");
        System.out.println("3. Excluir Cliente ");
        System.out.println("4. Atualizar Cliente ");
        System.out.println("5. Buscar Cliente ");
        System.out.println("0. Sair ");

        int opcao = sc.nextInt();
        sc.nextLine();  // Consumir quebra de linha

        switch (opcao) {
            // Cadastrar novo cliente
            case 1:
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

                String id = sc.nextLine();

                Cliente cliente = new Cliente(nome, cpf, telefone, email, rg, id);

                clienteRepository.salvar(cliente);

                System.out.println("Cliente cadastrado com sucesso!");
                break;

            // Listar clientes
            case 2:
               List<Cliente> clientes = clienteRepository.listar();



            // Excluir cliente
            case 3:

            // Atualizar dados do cliente
            case 4:

            // Buscar cliente
            case 5:

            // Sair/enecerrar programa
            case 0:


        }

    }

}
