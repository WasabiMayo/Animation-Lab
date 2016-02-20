package generalassembly.yuliyakaleda.startercode;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private ViewGroup viewGroup;
  private Button button;
  private EditText editText;
  private TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //TODO: set up all the view and event listeners.

    button = (Button)findViewById(R.id.addbutton);
    textView = (TextView) findViewById(R.id.wishtv);
    editText = (EditText) findViewById(R.id.edittext);

    LayoutTransition layoutTransition = new LayoutTransition();
    layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
    viewGroup = (ViewGroup)findViewById(R.id.ll);
    viewGroup.setLayoutTransition(layoutTransition);

    button.setOnClickListener(this);
    

  }

  @Override
  public void onClick(View v) {
    // TODO: 1. get the text from the input field
    //       2. animate it in the center of the screen
    //       3. add it to the list wish
    //       4. clear the input field

    String input = editText.getText().toString();

    textView.setText(input);
    Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
    textView.startAnimation(animation);

    final TextView addedWishTextView = new TextView(this);
    addedWishTextView.setText(input);
    addedWishTextView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        viewGroup.removeView(addedWishTextView);
      }
    });

    viewGroup.addView(addedWishTextView,0);
    editText.setText("");
  }
}
