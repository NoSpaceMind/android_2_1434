package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserList userList = UserList.get();                                 // создаём список у класса UserList через метод get
        FragmentManager fragmentManager = getSupportFragmentManager();      // менеджер для управления активностью Fragment
        Fragment fragment = new UserListFragment();                         // запускать фрагмент класса UserFragment
        // V beginTransaction - помещаем эл-ты на экран в fragmentContainer, наполненый fragment'ами  // commit - для фиксации на кране
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
    }
}