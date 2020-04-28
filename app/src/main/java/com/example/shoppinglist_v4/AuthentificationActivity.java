package com.example.shoppinglist_v4;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class AuthentificationActivity extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    public EditText mName, mPassword;
    private Button btnLogin;
    private CheckBox mCheckBox;
    private Button btnSupport;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        mName = (EditText) findViewById(R.id.et_name);
        mPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        mCheckBox = findViewById(R.id.checkBox_login);


        // mPreferences = PreferenceManager.getDefaultSharedPreferences(this); //changed - function was deprecated
        //"declaring database"
        mPreferences = getSharedPreferences("com.example.authentificationtest", Context.MODE_PRIVATE);
        //store
        mEditor = mPreferences.edit();

        checkSharePreferences();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save the checkbox preference
                if(mCheckBox.isChecked()){

                    //set a checkbox when the app starts
                    mEditor.putString(getString(R.string.checkbox),"True");
                    mEditor.commit();

                    //save the name
                    String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name),name);
                    mEditor.commit();

                    //save the password
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password),password);
                    mEditor.commit();

                }   else{

                    //set checkbox when the app starts
                    mEditor.putString(getString(R.string.checkbox),"False");
                    mEditor.commit();


                   // String name = mName.getText().toString();
                    mEditor.putString(getString(R.string.name),"");
                    mEditor.commit();

                    //String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password),"");
                    mEditor.commit();
                }

                // login btn OnClick starts next activity


                Intent myIntent = new Intent(AuthentificationActivity.this, NotesListActivity.class);

                AuthentificationActivity.this.startActivity(myIntent);


            }
        });


        btnSupport = findViewById(R.id.btn_support);
        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(AuthentificationActivity.this, MapsFragmentA.class);

                AuthentificationActivity.this.startActivity(myIntent);
            }
        });

    }

    private void checkSharePreferences(){

        String checkBox = mPreferences.getString(getString(R.string.checkbox),"False");
        String name = mPreferences.getString(getString(R.string.name),"");
        String password = mPreferences.getString(getString(R.string.password),"");

        mName.setText(name);
        mPassword.setText(password);

        if(checkBox.equals("True"))
        {
            mCheckBox.setChecked(true);
        }
        else {
            mCheckBox.setChecked(false);
        }


    }



}

