package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserFragment extends Fragment {            // расширяем/наследуемся UserFragment от класса Fragment
    private User user;                                  // создаём объект user
    private TextView userName_userLastname_View;        // привязываем TextView по id (userName_userLastname_View)
    @Override                                           // переопределяем
    public void onCreate(Bundle savedInstanceState){    // метод onCreate, чтобы определить дей ствия при создании активности
        super.onCreate(savedInstanceState);             // метод супер для обращения к onCreate родительского класса
        user = new User();                              // user
        user.setUserName("Ivan");                       // устанавливаем через set-р имя ("Ivan")
        user.setUserLastName("Ivanov");                 // устанавливаем через set-р фамилию ("Ivanov")
    }
    @Override  // создаём фрагмент появления активности Create с аргументами LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    // LayoutInflater inflater - расширяем/раздуваем разметку объекта (Layout)Inflater
    // ViewGroup container
    // Bundle savedInstanceState - временное хранение данных savedInstanceState

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){  // onCreateView фрагмент создает визуальный интерфейс
        // вручную/указав (false) расширяем/раздуваем слой fragment_user в контейнером (container) при помощи метода inflate
        View view = inflater.inflate(R.layout.fragment_user,container,false);       // false - не добавлять элементы родителя
        userName_userLastname_View = view.findViewById(R.id.userName_userLastname_View);        // связываем TextView с данным фрагментом
        String userName = "Имя: "+user.getUserName()+"\n"+"Фамилия: "+user.getUserLastName();   // формируем для вывода на экран имя и фамилию
        userName_userLastname_View.setText(userName);                                           // устанавливаем через set-р текст вывода

        return view;                                    // возвращаем фрагмент view (запускаем в работу)
    }
}
