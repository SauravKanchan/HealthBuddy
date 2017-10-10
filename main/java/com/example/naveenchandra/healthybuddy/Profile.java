package com.example.naveenchandra.healthybuddy;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static java.lang.Integer.parseInt;

public class Profile extends AppCompatActivity{
    private static final String TAG = "Profile";
    DatabaseHelper databaseHelper;
    EditText editDisease,editDescription,editMedicines,removeId;
    Button update,view,clear_all,remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        databaseHelper= new DatabaseHelper(this);
        editDisease = (EditText) findViewById(R.id.txtDiseases);
        editDescription =(EditText) findViewById(R.id.txtDescription);
        editMedicines =(EditText) findViewById(R.id.txtMedicines);
        removeId = (EditText) findViewById(R.id.numid);
        update = (Button) findViewById(R.id.button);
        view =(Button) findViewById(R.id.btnView);
        clear_all=(Button) findViewById(R.id.btnClearHistory);
        remove = (Button) findViewById(R.id.btnRemove);
        clear_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.refresh();

            }
        });
        try{
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(removeId.getText()==null){removeId.setText("0");}
                    Log.d("27872878727", " "+removeId.getText());
                databaseHelper.removeById(parseInt(removeId.getText().toString()));

                removeId.setText("");
            }
        });}catch (Exception e){}
        addData();
        viewLL();
        Log.d("9654", editDisease.getText().toString()+"\n"+
                editDescription.getText().toString()+"\n"+
                editMedicines.getText().toString());


    }

    public void addData(){
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editDisease.getText()==null||editMedicines.getText()==null||editDescription.getText()==null){}{
                    databaseHelper.insertData(
                            editDisease.getText().toString(),
                            editDescription.getText().toString(),
                            editMedicines.getText().toString());
                editDisease.setText("");
                editDescription.setText("");
                editMedicines.setText("");
            }}
        });
    }

    public void viewLL(){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res =databaseHelper.getAllData();
                if(res.getCount()==0){
                    showMessage("Error","No data found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (res.moveToNext()){
                    buffer.append("ID:-          "+res.getString(0)+"\n");
                    buffer.append("Disease:-     "+res.getString(1)+"\n");
                    buffer.append("Description:- "+res.getString(2)+"\n");
                    buffer.append("Medicine:-    "+res.getString(3)+"\n\n");
                }
                    showMessage("Profile",buffer.toString());
            }
        });
    }

    public void showMessage(String Title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();


    }

}
