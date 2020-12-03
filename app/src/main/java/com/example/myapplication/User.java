package com.example.myapplication;

import java.util.UUID;

// Класс пользователя
public class User {
    private String userName;                            // имя пользователя
    private String userLastName;                        // фамилия пользователя
    private UUID uuid;                                  // уникальный № пользователя

    public User() {
        this.uuid = UUID.randomUUID();                  // присваиваем этому(this) uuid случайный номер
    }

    public String getUserName() {
        return userName;                                // возвращаем имя пользователя из класса
    }

    public void setUserName(String userName) {          // назначем имя пользователя
        this.userName = userName;                       // ЭТОТ пользователь (данного класса) = userName
    }

    public String getUserLastName() {
        return userLastName;                            // возвращаем фамилию пользователя из класса
    }

    public void setUserLastName(String userLastName) {  // назначем фамилию пользователя
        this.userLastName = userLastName;               // ЭТОТ пользователь (данного класса) = userLastName
    }

    public UUID getUuid() {
        return uuid;                                    // возвращаем уникальный номер пользователя из класса
    }
}
