package com.assistos.service;

import java.security.SecureRandom;


public class ClienteService {

    // gerar ID automaticamente para cliente sendo cadastrado
    public String gerarId() {
        return String.valueOf(new SecureRandom().nextLong(0, Long.MAX_VALUE));
    }
}
