package in.xperinn.mpetition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AboutGameActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_about_game);
		Button back = (Button)findViewById(R.id.Back);
		back.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                Intent goToPlaypetti = new Intent(AboutGameActivity.this,CoreActivity.class);
                startActivity(goToPlaypetti);
                
            }
        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about_game, menu);
		return true;
	}

}
