package com.example.welprating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class FeedbackActivity extends AppCompatActivity {
    EditText Feedback;
    RatingBar RatingBar;
    Button FeedbackSend;
    TextView RatingLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Feedback = findViewById(R.id.etFeedback);
        RatingBar = findViewById(R.id.ratingBar);
        FeedbackSend = findViewById(R.id.btnSubmit);
        RatingLevel = findViewById(R.id.tvRatingScale);

        //Able to interact and give rating with Android RatingBar,
        RatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                RatingLevel.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        RatingLevel.setText("Could have been better.");
                        break;
                    case 2:
                        RatingLevel.setText("It was ok.");
                        break;
                    case 3:
                        RatingLevel.setText("Good.");
                        break;
                    case 4:
                        RatingLevel.setText("Great.");
                        break;
                    case 5:
                        RatingLevel.setText("Awesome. Really helpful!");
                        break;
                    default:
                        RatingLevel.setText("");
                }
            }
        });

        //Make Android Button clickable.
        FeedbackSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (FeedbackSend.getText().toString().isEmpty()) {
                    Toast.makeText(FeedbackActivity.this, "Please fill in the feedback text box", Toast.LENGTH_LONG).show();
                } else {
                    FeedbackSend.setText("");
                    RatingBar.setRating(0);
                    Toast.makeText(FeedbackActivity.this, "Thanks for sharing your feedback with the CAs!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
