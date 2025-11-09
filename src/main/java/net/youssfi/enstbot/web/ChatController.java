package net.youssfi.enstbot.web;

import net.youssfi.enstbot.agents.AIAgent;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {
    private AIAgent aiAgent;

    public ChatController(AIAgent aiAgent) {
        this.aiAgent = aiAgent;
    }
    @GetMapping(value = "/chat", produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(@RequestParam(name = "query") String query) {
        return aiAgent.askAgent(query);
    }
}
