package com.ferrianwebsterdictionary.app.demo.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ferrianwebsterdictionary.app.demo.dto.ApiWordResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CustomWordDeserializer {


//    protected CustomWordDeserializer(Class<?> vc) {
//        super(vc);
//    }
//
//    protected CustomWordDeserializer(JavaType valueType) {
//        super(valueType);
//    }
//
//    protected CustomWordDeserializer(StdDeserializer<?> src) {
//        super(src);
//    }
//
//    private final static List<String> wordProperties = Arrays.asList("word", "phonetic", "phonetics", "origin", "meanings");
//
//    @Override
//    public ApiWordResponse deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
//        ApiWordResponse apiWordResponse = new ApiWordResponse();
//        ObjectCodec codec = jsonParser.getCodec();
//        JsonNode node = codec.readTree(jsonParser);
//
//        wordProperties.forEach(property -> {
//            JsonNode propertyNode = node.get(property);
//            Object propertyValue = propertyNode.asText();
//        });


//    }
}
