package com.app.han.myapplication_draganddrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.app.han.myapplication_draganddrop.model.User;
import com.app.han.myapplication_draganddrop.model.UsersData;
import com.app.han.myapplication_draganddrop.view.SwipeAndDragHelper;
import com.app.han.myapplication_draganddrop.view.UserListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView userRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_user_list);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserListAdapter adapter = new UserListAdapter();
        SwipeAndDragHelper swipeAndDragHelper = new SwipeAndDragHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(swipeAndDragHelper);
        adapter.setTouchHelper(touchHelper);
        userRecyclerView.setAdapter(adapter);
        touchHelper.attachToRecyclerView(userRecyclerView);

        UsersData usersData = new UsersData();
        List<User> usersList = usersData.getUsersList();
        adapter.setUserList(usersList);
    }
}
