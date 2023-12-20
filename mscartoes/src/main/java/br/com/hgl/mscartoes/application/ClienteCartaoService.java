package br.com.hgl.mscartoes.application;

import br.com.hgl.mscartoes.domain.ClienteCartao;
import br.com.hgl.mscartoes.infra.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {
    private final ClienteCartaoRepository repository;


    public List<ClienteCartao> ListCartoesByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
