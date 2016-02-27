package dialaroomcar.com.demoprojectgitversion;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GitMainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private TextView txtPostList;
    private ArrayList<BeanPost> beanPostArrayList;
    private StringBuffer postList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_main);
        txtPostList = (TextView) findViewById(R.id.txtPostList);
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(GitMainActivity.this);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
            }

            @Override
            protected Void doInBackground(Void... voids) {

                Reader reader = API.getData("http://beta.json-generator.com/api/json/get/DiIRBM4");

                Type listType = new TypeToken<ArrayList<BeanPost>>() {
                }.getType();
                beanPostArrayList = new GsonBuilder().create().fromJson(reader, listType);
                postList = new StringBuffer();
                for (BeanPost post : beanPostArrayList) {
                    postList.append("\n title: " + post.getPost_name() + "\n auther: " + post.getAuther() + "\n date: " + post.getDate() + "\n description: " + post.getDescription() + "\n\n");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                progressDialog.dismiss();
                txtPostList.setText(postList);

            }
        }.execute();
    }

}