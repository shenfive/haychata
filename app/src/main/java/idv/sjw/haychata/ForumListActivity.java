package idv.sjw.haychata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;

import static idv.sjw.haychata.R.layout.fourm_listitem;

public class ForumListActivity extends AppCompatActivity {

    DatabaseReference rootRef;
    ListView fourmList;
    MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_list);

        fourmList = (ListView)findViewById(R.id.fourmList);


        rootRef = FirebaseDatabase.getInstance().getReference().child("forum");

        final ArrayList<FourmAdapterItem> listForumData = new ArrayList<FourmAdapterItem>();
//        listForumData.add(new FourmAdapterItem("a", "b", "c"));




        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.d("data",dataSnapshot.toString());
                for(DataSnapshot childDataSnapshot: dataSnapshot.getChildren()){
                    String subject = childDataSnapshot.child("subject").getValue().toString();
                    Log.d("subject",subject);
                    String date = childDataSnapshot.child("lastUpdate").getValue().toString();
                    Log.d("date",date);
                    String lastSpeaker = childDataSnapshot.child("lastSpeaker").getValue().toString();
                    Log.d("lastSpeaker",lastSpeaker);
                    listForumData.add(new FourmAdapterItem(subject,date,lastSpeaker));
                }
                myCustomAdapter = new MyCustomAdapter(listForumData);
                fourmList.setAdapter(myCustomAdapter);


            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        rootRef.addListenerForSingleValueEvent(valueEventListener);


    }

    private  class  MyCustomAdapter extends BaseAdapter{

        public ArrayList<FourmAdapterItem> listForumDataAdapter;
        private LayoutInflater layoutInflater;

        public MyCustomAdapter(ArrayList<FourmAdapterItem> listForumDataAdapter){
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
            View myView = mInflater.inflate(R.layout.fourm_listitem,null);
////            View myView = layoutInflater.inflate(R.layout.fourm_listitem,null);
//
//            View myView = convertView;
//
//            myView = getLayoutInflater().inflate(R.layout.fourm_listitem,null);

            final FourmAdapterItem s = listForumDataAdapter.get(position);

//
            TextView subject = (TextView)myView.findViewById(R.id.subject);
            subject.setText(s.subject);
            TextView date = (TextView)myView.findViewById(R.id.lastUpdate);
            date.setText(s.lastUpdateDate);
            TextView lastSpeaker = (TextView)myView.findViewById(R.id.lastSpeaker);
            lastSpeaker.setText(s.subject);
            return myView;
        }
    }


}
