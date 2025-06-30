package gabriellucena98.livechatms.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig: WebSocketMessageBrokerConfigurer {

    //utilizando o stomp broker em memória, sem rabbitmq ou qlqr tipo de mensageria
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        //nome do tópico que queremos criar
        registry.enableSimpleBroker("/topics")
        //prefiro para a nossa aplicação
        registry.setApplicationDestinationPrefixes("/app")
    }

    //Configurando o endpoint da WebSocketAPI
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/livechat-websocket")
    }
}