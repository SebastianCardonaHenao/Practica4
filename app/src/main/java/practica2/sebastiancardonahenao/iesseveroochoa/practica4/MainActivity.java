package practica2.sebastiancardonahenao.iesseveroochoa.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
               // getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Toast.makeText(this, R.string.anyadir,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_del:
                Toast.makeText(this, R.string.eliminar,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_acercade:
                Toast.makeText(this, R.string.acercade,Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}