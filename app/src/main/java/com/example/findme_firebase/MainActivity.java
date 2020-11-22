package com.example.findme_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button logout;
    private EditText edit;
    private Button add;
    private ListView listView;
    private ToggleButton toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.logout);
        edit = findViewById(R.id.edit);
        add = findViewById(R.id.add);
        listView = findViewById(R.id.listView);
        toggle = findViewById(R.id.toggle);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isMaster) {
                if (isMaster) {
                    edit.setText("true"); //send true at random intervals
                    //delay for a random period of time before sending false
                } else {
                    //ignore all incoming data
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, StartActivity.class));
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_name = edit.getText().toString();
                if (txt_name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nothing entered", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseDatabase.getInstance().getReference().child("Languages").child("Name").setValue(txt_name);
                }
            }
        });

        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, list);
        listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Languages");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    list.add(snapshot.getValue().toString());
                }
                adapter.notifyDataSetChanged();;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //HashMap<String, Object> map = new HashMap<>();
        //map.put("Name", "Rishav");
        //map.put("Email", "gmail.com");
        //FirebaseDatabase.getInstance().getReference().child("ProgrammingKnowledge").child("MultipleValues").updateChildren(map);
    }
}
