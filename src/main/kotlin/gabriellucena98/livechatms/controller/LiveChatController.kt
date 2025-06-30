package gabriellucena98.livechatms.controller

import gabriellucena98.livechatms.domain.ChatInput
import gabriellucena98.livechatms.domain.ChatOutput
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils

//como não é uma rest api, não usa o @RestController
@Controller
class LiveChatController {

    //indica a rota que recebemos esse nosso frame, para depois fazer o processamento
    @MessageMapping("/new-message")
    //O que recebemos, nós queremos enviar para o stomp broker, logo usamos sendTo para enviar
    @SendTo("/topics/livechat")
    //endpoint de receber novas mensagens
    fun newMessage(input: ChatInput): ChatOutput {
        return ChatOutput(HtmlUtils.htmlEscape("${input.user}: ${input.message}"))
    }

    //htmlEscape serve para ter segurança e não receber nenhum script no message que execute para todos os users
}