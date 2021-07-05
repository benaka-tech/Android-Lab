package com.example.a4ex;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Environment;
import android.os.Bundle;
import android.widget.GridView;
import java.io.File;
import java.util.ArrayList;

public class Second extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final GridView gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new CustomAdapter(Second.this, getData()));
    }

    private ArrayList<ImageModel> getData() {
        ArrayList<ImageModel> imgModel = new ArrayList<>();
        try {


            File DownloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
            ImageModel im;
            if (DownloadFolder.exists()) {
                File[] files = DownloadFolder.listFiles();
                for (int i = 0; i < files.length; i++) {
                    File file = files[i];
                    im = new ImageModel();
                    im.setName(file.getName());
                    im.setUri(Uri.fromFile(file));
                    imgModel.add(im);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgModel;
    }
}
