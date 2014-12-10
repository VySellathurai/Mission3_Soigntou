package org.davy.soigntou;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button but1;
	private EditText editKm;
	private String strDistance;
	private int distance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		but1 = (Button)this.findViewById(R.id.button1);
		editKm = (EditText)this.findViewById(R.id.editKm);
		but1.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		Intent go = new Intent(this,AllPharmaciesActivity.class);
		strDistance = editKm.getText().toString();
		if (strDistance.trim().equals("")) {
			new AlertDialog.Builder(this).setTitle("Attention !")
				.setMessage("Vous n'avez pas mis de rayon de recherche !")
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {			
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub				
					}		
				}).show();
		} 
		else {
			distance = Integer.parseInt(strDistance);
			go.putExtra("rayon",distance);
			this.startActivityForResult(go, 10);
		}
	}
}
