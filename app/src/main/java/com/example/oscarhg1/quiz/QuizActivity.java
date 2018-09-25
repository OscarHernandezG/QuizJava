package com.example.oscarhg1.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscarhg1.quiz.PreguntaTest;

public class QuizActivity extends AppCompatActivity {

    private PreguntaTest pregunta;
    private RadioGroup respuestasView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        generarPregunta();

        TextView textView = findViewById(R.id.textView);
        respuestasView = findViewById(R.id.respuestasView);
        RadioButton buttonRespuesta0 = findViewById(R.id.buttonRespuesta0);
        RadioButton buttonRespuesta1 = findViewById(R.id.buttonRespuesta1);
        RadioButton buttonRespuesta2 = findViewById(R.id.buttonRespuesta2);
        RadioButton buttonRespuesta3 = findViewById(R.id.buttonRespuesta3);

        textView.setText(pregunta.getText());
        buttonRespuesta0.setText(pregunta.getRespuestas()[0]);
        buttonRespuesta1.setText(pregunta.getRespuestas()[1]);
        buttonRespuesta2.setText(pregunta.getRespuestas()[2]);
        buttonRespuesta3.setText(pregunta.getRespuestas()[3]);
    }

    private void generarPregunta()
    {
        String[] respuestas = new String[4];
        respuestas[0] = "Barcelona";
        respuestas[1] = "Paris";
        respuestas[2] = "Londres";
        respuestas[3] = "Hanoi";

        pregunta = new PreguntaTest("Capital de Vietnam", respuestas, 3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quiz_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.checkMenu:
                checkAnswer();
                break;
        }

        return true;
    }

    private void checkAnswer()
    {
        int index = getButtonIndex();

        if (index == pregunta.getCorrect())
        {
            Toast.makeText(this, "Correct!",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Incorrect :(",Toast.LENGTH_LONG).show();
        }



    }

    private int getButtonIndex()
    {
        int selected = respuestasView.getCheckedRadioButtonId();

        int id[] = {R.id.buttonRespuesta0, R.id.buttonRespuesta1, R.id.buttonRespuesta2, R.id.buttonRespuesta3};

        int index = -1;
        for (int i = 0; i < id.length; i++)
        {
            if (id[i] == selected)
            {
                index = i;
                break;
            }
        }
        return index;
    }

}
