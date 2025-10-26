package br.com.venda.api.service;

import br.com.venda.api.model.Cliente;
import br.com.venda.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public List<Cliente> buscarPorNome(String nome) { return
            clienteRepository.findByNome(nome);
    }

    public Optional<Cliente> bucarPorId(Long id){
        return  clienteRepository.findById(id);
    }
}
