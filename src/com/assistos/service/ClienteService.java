package com.assistos.service;

import com.assistos.model.Cliente;

import java.security.SecureRandom;
import java.util.List;


public class ClienteService {

    // gerar ID automaticamente para cliente sendo cadastrado
    public String gerarId() {
        return String.valueOf(new SecureRandom().nextLong(0, Long.MAX_VALUE));
    }

    public boolean jaExisteCadastro(Cliente novo, List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            // na atualização ignora o próprio cadastro
            if (cliente.getId().equals(novo.getId())) {
                continue;
            }

            if (cliente.getEmail().equalsIgnoreCase(novo.getEmail()) ||
                    cliente.getCpf().equals(novo.getCpf()) ||
                    cliente.getTelefone().equals(novo.getTelefone()) ||
                    cliente.getRg().equals(novo.getRg())) {
                return true;  // encontrou dado repetido
            }
        }
        return false;
    }
}
