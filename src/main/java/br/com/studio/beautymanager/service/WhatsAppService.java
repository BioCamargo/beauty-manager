package br.com.studio.beautymanager.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhatsAppService {

    public void enviarMensagem(String telefone, String mensagem) {

        String url = "https://api.z-api.io/instances/SEU_ID/token/SEU_TOKEN/send-text";

        RestTemplate rest = new RestTemplate();

        String body = """
        {
           "phone": "%s",
           "message": "%s"
        }
        """.formatted(telefone, mensagem);

        rest.postForObject(url, body, String.class);

    }
}