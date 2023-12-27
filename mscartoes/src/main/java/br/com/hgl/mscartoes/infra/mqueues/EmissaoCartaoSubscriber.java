package br.com.hgl.mscartoes.infra.mqueues;

import br.com.hgl.mscartoes.domain.Cartao;
import br.com.hgl.mscartoes.domain.ClienteCartao;
import br.com.hgl.mscartoes.domain.DadosSolicitacaoEmissaoCartao;
import br.com.hgl.mscartoes.infra.repository.CartaoRepository;
import br.com.hgl.mscartoes.infra.repository.ClienteCartaoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;
    @RabbitListener(queues = "emissao-cartoes")
    public void receberSolicitacaoEmissao(@Payload String payload){

        try {
            System.out.println("Mensagem Fila: " + payload);
            var mapper = new ObjectMapper();
            DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao =
                    mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);
            Cartao cartao = cartaoRepository.findById(dadosSolicitacaoEmissaoCartao.getIdCartao()).orElseThrow();
            ClienteCartao clienteCartao = new ClienteCartao();
            clienteCartao.setCartao(cartao);
            clienteCartao.setCpf(dadosSolicitacaoEmissaoCartao.getCpf());
            clienteCartao.setLimite(dadosSolicitacaoEmissaoCartao.getLimiteLiberado());

            clienteCartaoRepository.save(clienteCartao);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
