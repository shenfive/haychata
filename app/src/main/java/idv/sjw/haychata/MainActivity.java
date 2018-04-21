package idv.sjw.haychata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;

    TextView message;
    EditText nickname;
    SharedPreferences nameSetting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        FirebaseAuth.getInstance().signInAnonymously();

        message = (TextView)findViewById(R.id.msg);
        nickname = (EditText)findViewById(R.id.nickname);

        nameSetting =getSharedPreferences("nameSetting",0);
        nickname.setText(nameSetting.getString("name",""));




    }

    public void enterForum(View v){

        String nicknameStrig = nickname.getText().toString();
        if (nicknameStrig.length() < 1) {
            Toast.makeText(this,"錯誤:暱稱至少兩字",Toast.LENGTH_SHORT).show();
            message.setText("錯誤:暱稱至少兩字");
            return;
        }


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null){
            //進入下一個 Activity
            nameSetting.edit().putString("name",nicknameStrig).commit();
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ForumListActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"錯誤:無法成功連線",Toast.LENGTH_SHORT).show();
            message.setText("錯誤:錯誤:無法成功連線");
            return;
        }

    }



}
