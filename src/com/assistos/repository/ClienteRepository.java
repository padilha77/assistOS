package com.assistos.repository;

import com.assistos.model.Cliente;
import java.util.List;
import java.util.ArrayList;

public class ClienteRepository {

        private final List<Cliente> clientes = new ArrayList<>();

        public void salvar(Cliente cliente) {

            this.clientes.add(cliente);

        }

        public List<Cliente> listar() {
            return List.copyOf(clientes);
        }

}
