package administrator.example.com.welcomeview.WelCome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dd.processbutton.iml.GenerateProcessButton;

import administrator.example.com.welcomeview.R;
import administrator.example.com.welcomeview.utils.ProgressGenerator;

public class UploadActivity extends Activity implements ProgressGenerator.OnCompleteListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_upload);

        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
        final GenerateProcessButton btnUpload =
                (GenerateProcessButton)findViewById(R.id.btnUpload);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnUpload);
                btnUpload.setEnabled(false);
            }
        });

    }

    @Override
    public void onComplete() {

        Toast.makeText(this,R.string.Loading_Complete,Toast.LENGTH_LONG).show();

    }
}
