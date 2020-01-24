package br.wscomvix.wspaymentcontrol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;

public class CalendarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        setTitle("Calendário");

    }

    public void retornaDataAtual(View v) {
        CalendarView cal = findViewById(R.id.calendarView);
        Date d = new Date(cal.getDate());

        Intent i = new Intent();
        i.putExtra("data_atual", DateFormat.getInstance().format(d));
        setResult(RESULT_OK, i);

        finish();
    }
}
