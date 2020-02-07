package my.tech.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtWidth, edtHeight, edtLength;
    private TextView tvResult;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        tvResult = findViewById(R.id.tv_result);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        displayResult();

        findViewById(R.id.btn_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String width = edtWidth.getText().toString();
                String height = edtHeight.getText().toString();
                String length = edtLength.getText().toString();

                if (width.isEmpty()) {
                    edtWidth.setError("Masih Kosong");
                } else if (height.isEmpty()) {
                    edtHeight.setError("Masih Kosong");
                } else if (length.isEmpty()) {
                    edtLength.setError("Masih Kosong");
                } else {
                    viewModel.calculate(width, height, length);
                    displayResult();
                }
            }
        });
    }

    private void displayResult() {
        tvResult.setText(String.valueOf(viewModel.result));
    }
}
