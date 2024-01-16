package com.imrzoom.desafiouol.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class CodenameService {

    private final RestTemplate restTemplate;
    private final Environment env;

    private List<String> avengersCodenameList = new ArrayList<>();
    private List<String> justiceLeagueList = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    public CodenameService(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        this.env = env;
    }

    @PostConstruct
    public void loadJsonData(){
        try{
            String codenameResponse = restTemplate.getForObject(env.getProperty("avengers"), String.class);
            JsonNode jsonNode = objectMapper.readTree(codenameResponse);

            ArrayNode avangers = (ArrayNode) jsonNode.get("vingadores");

            for(JsonNode item: avangers){
                this.avengersCodenameList.add(item.get("codinome").asText());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void loadXmlData(){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =  factory.newDocumentBuilder();
            Document document = builder.parse(env.getProperty("justice.league"));

            NodeList codenameList = document.getElementsByTagName("codinome");

            for(int i = 0; i < codenameList.getLength(); i++){
                Element codenameElement = (Element) codenameList.item(i);
                String codename = codenameElement.getTextContent();
                this.justiceLeagueList.add(codename);
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
