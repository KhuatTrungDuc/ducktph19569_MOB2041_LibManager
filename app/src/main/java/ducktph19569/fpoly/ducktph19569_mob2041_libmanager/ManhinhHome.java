package ducktph19569.fpoly.ducktph19569_mob2041_libmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.Login.Login;

public class ManhinhHome extends AppCompatActivity {
   private EditText ed_login;
   private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinh_home);
        ed_login = findViewById(R.id.ed_login);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkmsv();
            }
//                String msv = ed_login.getText().toString();
//                if(msv.equalsIgnoreCase("ducktph19569")){
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                    builder.setView(v);
//                    builder.setTitle("OK");
//                    builder.show();
//
//
//                    Intent intent = new Intent(ManhinhHome.this, Login.class);
//                    startActivity(intent);
//                }else {
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                    builder.setView(v);
//                    builder.setTitle("Sai mã sinh viên");
//                    builder.show();
//                }


//            }
        });
    }
    public void checkmsv(){
        String msv = ed_login.getText().toString();
        if(msv.equalsIgnoreCase("ducktph19569")){
//            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//            builder.setView(view);
//            builder.setTitle("                Sửa Sách");

            Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ManhinhHome.this, Login.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Sai mã sinh viên", Toast.LENGTH_SHORT).show();

        }

    }



//    public void loo(View view) {
//        Intent intent = new Intent(ManhinhHome.this, Login.class);
//
//        startActivity(intent);
//
//    }
}