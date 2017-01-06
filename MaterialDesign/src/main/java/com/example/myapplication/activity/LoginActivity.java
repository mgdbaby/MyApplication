package com.example.myapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.myapplication.Book;
import com.example.myapplication.MyAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.R.id.coordinator;


public class LoginActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Book> bookList;
    private MyAdapter myAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("CollapsingToolbarLayout");
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);

        initAdapter();
        initRecycleView();

//        TextInputLayout mTextInputLayoutName = (TextInputLayout) findViewById(R.id.textInput_layout_name);
//        TextInputLayout mTextInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInput_layout_password);
//        //mTextInputLayoutName.getEditText()返回的是它的子EditText控件，一个TextInputLayout只能包含一个EditText控件
//        mTextInputLayoutName.getEditText().addTextChangedListener(new MyTextWatcher(mTextInputLayoutName, "用户名长度不能小于6位"));
//        mTextInputLayoutPassword.getEditText().addTextChangedListener(new MyTextWatcher(mTextInputLayoutPassword, "密码长度不能小于6位"));


        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(coordinator);
        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(coordinatorLayout,"带按钮的SnackBar",Snackbar.LENGTH_SHORT).setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LoginActivity.this, ToolBarLayoutActivity.class);
                        startActivity(intent);
                    }
                }).show();
            }
        });

    }

    private void initAdapter() {
        bookList=new ArrayList<>();
        bookList.add(new Book("Hello~~~","fssflkjkkj"));
        bookList.add(new Book("Nice to meet U","老板老板"));
        bookList.add(new Book("Hello~~~","fssflkjkkj"));
        bookList.add(new Book("Nice to meet U","老板老板"));
        bookList.add(new Book("Hello~~~","fssflkjkkj"));
        bookList.add(new Book("Nice to meet U","老板老板"));
        bookList.add(new Book("Hello~~~","fssflkjkkj"));
        bookList.add(new Book("Nice to meet U","老板老板"));
        bookList.add(new Book("Hello~~~","fssflkjkkj"));
        bookList.add(new Book("Nice to meet U","老板老板"));
        bookList.add(new Book("Hello~~~","fssflkjkkj"));
        bookList.add(new Book("Nic to meet U","老板老板"));

        myAdapter = new MyAdapter(this, bookList);
    }

    private void initRecycleView() {
        //设置布局管理器
        recyclerView.setLayoutManager(linearLayoutManager);

        myAdapter.setOnRecyclerItemClickListener(new MyAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
            }
        });
        //设置adapter
        recyclerView.setAdapter(myAdapter);
        //设置默认动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

}
