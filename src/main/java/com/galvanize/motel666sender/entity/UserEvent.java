package com.galvanize.motel666sender.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserEvent {

    String type;

    String userId;

    String context;

    @Builder
    public UserEvent(String type, String userId, String context) {
        this.type = type;
        this.userId = userId;
        this.context = context;
    }
}
