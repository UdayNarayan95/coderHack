package com.uday.coderHack.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.uday.coderHack.dtos.Badge;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Document(collection = "users")
@NoArgsConstructor
public class UserEntity {
    @Id
    private String userId;

    private String username;

    private int score;
    
    private List<Badge> badges = new ArrayList<>();
}
