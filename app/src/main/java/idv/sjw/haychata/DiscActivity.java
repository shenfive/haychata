package idv.sjw.haychata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DiscActivity extends AppCompatActivity {

    TextView subject;
    ListView disclist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disc);

        subject = (TextView)findViewById(R.id.subject);
        disclist = (ListView)findViewById(R.id.disclist);

        Bundle bundle = getIntent().getExtras();

        //設定標題
        subject.setText(bundle.getString("subject"));


        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("fourm");
        String key = bundle.getString("discKey");



    }
    private  class  DiscCustomAdapter extends BaseAdapter {

        public ArrayList<DiscContent> listForumDataAdapter;
        private LayoutInflater layoutInflater;

        public DiscCustomAdapter(ArrayList<DiscContent> listForumDataAdapter){
            this.listForumDataAdapter = listForumDataAdapter;
        }


        @Override
        public int getCount() {
            return listForumDataAdapter.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.disc_content,null);


            myView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


            return myView;
        }
    }

}
