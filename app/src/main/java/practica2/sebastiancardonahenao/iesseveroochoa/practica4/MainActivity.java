package practica2.sebastiancardonahenao.iesseveroochoa.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.jar.JarEntry;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void accionBotones(View v) {
        Class claseActivity = null;
        switch (v.getId()) {
            case R.id.fab:
                claseActivity = AnyadirTarea.class;
                break;
        }
        Intent intent;
        intent = new Intent(this, claseActivity);
        startActivity(intent);
    }




}