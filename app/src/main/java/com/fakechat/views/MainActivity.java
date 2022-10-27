package com.fakechat.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.fakechat.R;
import com.fakechat.adapters.QuickShortcutAdapter;
import com.fakechat.interfaces.OnClickWithPosition;
import com.fakechat.models.items.ItemShortcut;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ItemShortcut> itemShortcutList = new ArrayList<>();
    private QuickShortcutAdapter quickShortcutAdapter;
    private CardView cvNumberWaitMess,
            cvCamera, cvPenCil, cvSearch,
            cvContainsMenu;
    private RecyclerView rvListMessenger, rvShortcutMessenger;
    private ImageView ivNavChats, ivNavCall, ivNavPeople, ivNavStory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        setOnClick();
        setAdapter();
    }

    private void setAdapter(){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
            rvShortcutMessenger.setLayoutManager(linearLayoutManager);
            quickShortcutAdapter = new QuickShortcutAdapter(testAddList(), new OnClickWithPosition() {
                @Override
                public void onClickWithPosition(int position) {
                    Toast.makeText(MainActivity.this, "Position: "+position, Toast.LENGTH_SHORT).show();
                }
            });
            rvShortcutMessenger.setAdapter(quickShortcutAdapter);
            quickShortcutAdapter.notifyDataSetChanged();
    }

    private List<ItemShortcut> testAddList(){
        for (int i = 0; i<10; i++){
            if (i< 1){
                itemShortcutList.add(new ItemShortcut(R.drawable.iv_test, true, "Trinh van manh"));
            } else {
                itemShortcutList.add(new ItemShortcut(R.drawable.iv_test, false, "nameShortcut"));
            }

        }
        return itemShortcutList;
    }
    /**
     * OnClick view in Activity
     */
    private void setOnClick(){
        cvNumberWaitMess.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserActivity.class);
            startActivity(intent);
        });

        cvContainsMenu.setOnClickListener(view -> {

        });

        cvCamera.setOnClickListener(view -> {

        });

        cvPenCil.setOnClickListener(view ->{

        });

        cvSearch.setOnClickListener(view->{

        });

        ivNavChats.setOnClickListener(view -> {

        });

        ivNavCall.setOnClickListener(view -> {

        });

        ivNavPeople.setOnClickListener(view -> {

        });

        ivNavStory.setOnClickListener(view -> {

        });

    }

//    mapping view in MainActivity
    private void mapping(){
        rvShortcutMessenger = findViewById(R.id.rv_shortcut_icon);
        rvListMessenger = findViewById(R.id.rv_list_messenger);
        ivNavChats = findViewById(R.id.iv_nav_bottom_chats);
        ivNavCall = findViewById(R.id.iv_nav_bottom_call);
        ivNavPeople = findViewById(R.id.iv_nav_bottom_people);
        ivNavStory = findViewById(R.id.iv_nav_bottom_story);
        cvNumberWaitMess = findViewById(R.id.cv_contains_waiting_mess);
        cvCamera = findViewById(R.id.cv_contains_camera);
        cvPenCil = findViewById(R.id.cv_contains_pencil);
        cvSearch = findViewById(R.id.cv_contains_search);
        cvContainsMenu = findViewById(R.id.cv_contain_menu_main);
    }
}