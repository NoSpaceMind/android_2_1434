package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserListFragment extends Fragment {            // расширяем/наследуемся UserFragment от класса Fragment
    private RecyclerView userRecyclerView;                  // привязываем RecyclerView по id userRecyclerView
    private UserAdapter userAdapter;                        // переменна Адаптера
    // Метод создаёт компонент View фрагмента из XML разметки
    @Override  // переопределяем onCreateView с параметрами
    // LayoutInflater inflater - расширяем/раздуваем разметку объекта (Layout)Inflater
    // ViewGroup viewGroup
    // Bundle savedInstanceState - временное хранение данных savedInstanceState
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_user_list,viewGroup,false);
        userRecyclerView = view.findViewById(R.id.userRecyclerView);                // ищем userRecyclerView на view по id
        // устанавливаем менеджера для userRecyclerView для компановки по очереди
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        UserList userList = UserList.get();                 // получаем объект UserList из класса UserList
        List<User> users = userList.getUsers();             // получаем список User'ов
        userAdapter = new UserAdapter(users);               // заносим список пользователей в Адаптер
        userRecyclerView.setAdapter(userAdapter);           // устанавливаем адаптер для userRecyclerView

        return view;                                        // возвращаем фрагмент view (запускаем в работу)
    }
    // расширяем UserHolder от класса RecyclerView
    private class UserHolder extends RecyclerView.ViewHolder{       // вспомогательный класс для отображения эл-в
        private TextView userItem;                                  //  TextView для имя/фамилия из userItem
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup){        // конструктор класса UserHolder
            // раздуваем/расширяем слой list_item_user элементом viewGroup
            super(inflater.inflate(R.layout.list_item_user,viewGroup,false));  // false - не добавлять элементы родителя
            userItem = itemView.findViewById(R.id.userItem);        // наполняем userItem текущей view(itemView)
        }
        public void bind(User user){                        // "связываем" юзера
            String userName = "Имя: "+user.getUserName()+"\n"+"Фамилия: "+user.getUserLastName()+"\n---------"; // формируем для вывода на экран имя и фамилию
            userItem.setText(userName);                     // устанавливаем значение userName для userItem
        }
    }
    // наследуем UserAdapter от класса RecyclerView с использованием для этого адаптера вьюхолдер UserHolder
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        private List<User> users;                                       // список пользователей
        public UserAdapter(List<User> users){                           // адаптер со списком пользователей
            this.users = users;                                         // Юзер списка = юзеру адаптера
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {  // создаёт эл-т списка
            LayoutInflater inflater = LayoutInflater.from(getActivity());   // раздуваем inflater'ом слой из Активности
            return new UserHolder(inflater,viewGroup);                      // возвращаем объект класса UserHolder
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) { // привязываем контент к эл-ту отображения
            User user = users.get(position);                                // присваиваем user позицию пользователя
            userHolder.bind(user);                                          // связываем позиции user
        }

        @Override
        public int getItemCount() {         // возвращает кол-во эл-в списка
            return users.size();            // коллекции пользователей
        }
    }

}
