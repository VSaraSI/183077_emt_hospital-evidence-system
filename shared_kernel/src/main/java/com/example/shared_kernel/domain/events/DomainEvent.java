package com.example.shared_kernel.domain.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@Getter
public class DomainEvent {

    private String topic;

    public DomainEvent(String topic) {
        this.topic=topic;
    }

    public DomainEvent() {

    }

    //metod do chija pomosh topikot i eventot koj e publikuvan go pretvorame
    //vo Json
    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        String output = null;
        try {
            output = objectMapper.writeValueAsString(this);
            System.out.println("ResultingJSONstring = " + output);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return output;
    }

    public String topic() {
        return topic;
    }

    //metod so koj podatoci vo Json format gi pretvorame vo objekt za da moze da go prikazeme
    public static <E extends DomainEvent> E fromJson(String json, Class<E> eventClass) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json,eventClass);
    }
}
