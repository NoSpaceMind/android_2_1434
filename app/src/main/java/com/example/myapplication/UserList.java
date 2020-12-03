package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

// Синглетный класс (может быть создан только один объект)
public class UserList {                     // класс, который отвечает за список пользователей
    private static UserList userList;       // создаём переменную userList класса UserList
    private List users;                     // Список пользователей
    public static UserList get(){           // создаём у данного класса get-р
        if(userList == null){               // если userList не существует
            userList = new UserList();      // тогда создаём new UserList
        }
        return userList;                    // иначе возвращаем что есть
    }
    private UserList(){                     // метод генерации списка пользователей
        users = new ArrayList();            // наполняем Список пользователями
        for(int i=0; i<100; i++){           // 100 циклов
            User user = new User();         // создать пользователя
            user.setUserName("ИМЯ_"+i);     // задать ИМЯ_(+порядковый номер)
            user.setUserLastName("Фамилия_"+i); // задать Фамилия_(+порядковый номер)
            users.add(user);                // добавить пользователя в список
        }
    }
    public List getUsers(){                 // возвращаем
        return users;                       // пользователей
    }
}