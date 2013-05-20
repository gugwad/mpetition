package in.xperinn.mpetition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class SettingGameActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_game);
		Button handlesound = (Button)findViewById(R.id.handle);
		handlesound.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Intent goToPlaypetti = new Intent(SettingGameActivity.this,CoreActivity.class);
                startActivity(goToPlaypetti);                
            }
        });
		 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setting_game, menu);
		return true;
	}

}
