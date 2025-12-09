package com.exemplo;
import com.Ingredientes;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public abstract class Sugestao {

    protected final Ingredientes ingredientes; 
    protected final ChatLanguageModel model;

    public Sugestao(Ingredientes ingredientes) {
        this.ingredientes = ingredientes;

        //String apiKey = Config.getConfig("api_Key");

        this.model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.2:1b")
                .timeout(java.time.Duration.ofSeconds(120))
                .maxRetries(0) // retira warnings
                //.apiKey(apiKey)
                .build();
    }

    public abstract void fazerSujestao();
}
