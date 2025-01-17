package com.javaBrewers.coffeeHaven.controller;

//import com.javaBrewers.coffeeHaven.service.AIService;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.document.Document;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.ResponseFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class AIController {

    private final OpenAiChatModel chatModel;

    public AIController(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @PostMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message") String message) throws IOException {
        ClassPathResource resource = new ClassPathResource("docs/products.txt");
        String documents = new String(resource.getInputStream().readAllBytes());

        String promptText = "Recommend top 3 coffee bean products that match these preferences of the customer: " + message +
                "You will recommend by using the products information present in the DOCUMENTS section." +
                "For each recommendation give a brief description on why you recommended it." +
                "Your response must be in JSON format following this schema\n" +
                "{\n recommendations:[{" +
                "    name: (string)\n" +
                "    description: (string)}," +
                "    name: (string)\n" +
                "    description: (string)}]" +
                "}" +
                "\n" +
                "\n" +
                "DOCUMENTS:\n" + documents;
        return Map.of("generation",this.chatModel.call(promptText));

        //this.chatModel.call(message)
    }


//    @Autowired
//    AIService aiService;
//
//    @PostMapping("/query")
//        public String getResponseFromText(@RequestParam String query){
//        try {
//
//            // Load similar documents based on the query
//            List<Document> similarDocuments = aiService.loadText(query);
//
//            // Create a UserMessage and SystemMessage
//            UserMessage userMessage = new UserMessage(query);
//            Message systemMessage = aiService.getSystemMessage(similarDocuments);
//
//            // Prepare the Prompt
//            Prompt prompt = new Prompt(List.of(systemMessage, userMessage));
//
//            // Call the ChatModel and retrieve the response
//            String response = chatModel.call(prompt).getResult().getOutput().getContent();
//
//            return response; // Return the response as a plain String
//
//        } catch (Exception e) {
//            e.printStackTrace(); // Log the error
//            return "An error occurred while processing your request: " + e.getMessage();
//        }
//            //Map<String,String>
//        }

}
