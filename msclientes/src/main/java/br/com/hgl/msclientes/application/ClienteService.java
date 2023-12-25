package br.com.hgl.msclientes.application;

import br.com.hgl.msclientes.domain.Cliente;
import br.com.hgl.msclientes.infra.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClientRepository clientRepository;

    @Transactional
    public Cliente save(Cliente cliente){
        return clientRepository.save(cliente);
    }

    public Optional<Cliente> getByCPF(String cpf){
        return clientRepository.findByCpf(cpf);
    }

    public List<Cliente> findAllByCpf(String cpf){

        List<Cliente> list = new ArrayList<Cliente>();

        if (cpf.length()==0){
            list = clientRepository.findAll(Sort.by("nome"));
        }else{
            list = clientRepository.findAllByCpf(cpf);
        }
       return list;
    }
}
