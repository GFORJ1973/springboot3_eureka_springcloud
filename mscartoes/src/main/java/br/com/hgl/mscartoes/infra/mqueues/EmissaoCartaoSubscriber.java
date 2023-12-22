package br.com.hgl.mscartoes.infra.mqueues;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {
    @RabbitListener(queues = "emissao-cartoes")
    public void receberSolicitacaoEmissao(@Payload String payload){
        System.out.println(payload);
    }
}
