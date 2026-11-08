package com.assistos.repository;

import com.assistos.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

        private final List<Cliente> clientes = new ArrayList<>();

        public void salvar(Cliente cliente) {

            this.clientes.add(cliente);

        }

        public List<Cliente> listar() {

            return List.copyOf(clientes);

        }


        public boolean excluir(String id) {
        Cliente cliente = buscarPorId(id);

        if (cliente == null) {
            return false;
        }
        return clientes.remove(cliente);
        }



        public void listarDados(Cliente cliente) {
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getRg());
            System.out.println(cliente.getTelefone());
            System.out.println(cliente.getEmail());
            System.out.println(cliente.getId());
        }

        public Cliente buscarPorId(String id) {
            for (Cliente cliente : clientes) {
                if (cliente.getId().equals(id)) {
                    return cliente;
                }
            }
            return null;
        }

        public boolean atualizar(Cliente cliente) {
            Cliente cadastrado = buscarPorId(cliente.getId());
            if (cadastrado == null) {
                return false;
            }

            cadastrado.setNome(cliente.getNome());
            cadastrado.setCpf(cliente.getCpf());
            cadastrado.setTelefone(cliente.getTelefone());
            cadastrado.setEmail(cliente.getEmail());
            cadastrado.setRg(cliente.getRg());
            return true;
        }

}
