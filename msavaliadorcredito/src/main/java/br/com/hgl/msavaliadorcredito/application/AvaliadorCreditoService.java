package br.com.hgl.msavaliadorcredito.application;

import br.com.hgl.msavaliadorcredito.domain.model.CartaoCliente;
import br.com.hgl.msavaliadorcredito.domain.model.DadosCliente;
import br.com.hgl.msavaliadorcredito.domain.model.SituacaoCliente;
import br.com.hgl.msavaliadorcredito.infra.clients.CartoesResourceClient;
import br.com.hgl.msavaliadorcredito.infra.clients.ClienteResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliadorCreditoService {

    private final ClienteResourceClient clienteResourceClient;
    private final CartoesResourceClient cartoesResourceClient;
    public SituacaoCliente obterSituacaoCliente(String cpf){
        ResponseEntity<DadosCliente> dadosClienteResponse = clienteResourceClient.dadosCliente(cpf);
        ResponseEntity<List<CartaoCliente>> cartoesResponse = cartoesResourceClient.getCartoesByCliente(cpf);

        return SituacaoCliente
                .builder()
                .cliente(dadosClienteResponse.getBody())
                .cartoes(cartoesResponse.getBody())
                .build();
    }
}
