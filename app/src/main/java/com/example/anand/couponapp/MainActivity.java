package com.example.anand.couponapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private FirebaseDatabase database;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    public static final int RC_SIGN_IN = 1;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=(Button)findViewById(R.id.differentView);

        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference();
        databaseReference.keepSynced(true);

        recyclerView=(RecyclerView)findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseAuth=FirebaseAuth.getInstance();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth obfirebaseAuth) {
                FirebaseUser user = obfirebaseAuth.getCurrentUser();

                    if(user!=null){
                        //addAdapter();

                    }else{
                        startActivityForResult(
                                AuthUI.getInstance()
                                        .createSignInIntentBuilder()
                                        .setAvailableProviders(Arrays.asList(
                                                new AuthUI.IdpConfig.EmailBuilder().build(),
                                                new AuthUI.IdpConfig.GoogleBuilder().build()
                                               ))
                                        .build(),
                                RC_SIGN_IN);

                        Toast.makeText(MainActivity.this, "You're now signed in. Welcome to CouponCountry.",
                                Toast.LENGTH_SHORT).show();
                    }
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == RC_SIGN_IN) {
                 if (resultCode == RESULT_OK) {
                     // Sign-in succeeded, set up the UI
                             Toast.makeText(this, "Signed in!", Toast.LENGTH_SHORT).show();
                          } else if (resultCode == RESULT_CANCELED) {
                               // Sign in was canceled by the user, finish the activity
                                Toast.makeText(this, "Sign in canceled", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                  }
            }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.menubrandopt){
            Intent intent = new Intent(MainActivity.this,Main4Activity.class);
            startActivity(intent);
        }else if(id==R.id.menusignoutopt){
            //sign out
            AuthUI.getInstance().signOut(this);
        }
        return true;
    }

    public void addAdapter(){
        FirebaseRecyclerAdapter<CouponData,CouponViewHolder> firebaseRecyclerAdapter = new
                FirebaseRecyclerAdapter<CouponData, CouponViewHolder>
                        (CouponData.class,R.layout.cardrow,CouponViewHolder.class,databaseReference) {
                    @Override
                    protected void populateViewHolder(CouponViewHolder viewHolder, CouponData model, int position) {
                        viewHolder.setTitle(model.getBrand());
//                      viewHolder.setCardCategory(model.getCategory());
                        viewHolder.setDiscount(model.getDiscount());
                        viewHolder.setCardCondition(model.getCondition());
                        viewHolder.setImage(getApplicationContext(), model.getImage());

                    }

                };

        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
            addAdapter();

    }


        @Override
    protected void onResume() {
     super.onResume();

            firebaseAuth.addAuthStateListener(authStateListener);

    }


    @Override
    protected void onPause() {
        super.onPause();
        firebaseAuth.removeAuthStateListener(authStateListener);
    }
}

