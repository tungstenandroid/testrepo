package dialaroomcar.com.demoprojectgitversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class GitMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_main);
        Toast.makeText(GitMainActivity.this, "Show toast", Toast.LENGTH_SHORT).show();
    }
}
