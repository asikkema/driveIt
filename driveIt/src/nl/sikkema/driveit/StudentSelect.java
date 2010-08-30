package nl.sikkema.driveit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class StudentSelect extends Activity {

	private static String[] students = {"Jan", "Paul", "Hendrik", "Peter", "Mike", "Anita", "Berber", "Chantal", "Rutger", "Auke", "Diana", "Henk"};
	private ListView studentsList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_select);
		studentsList = (ListView) findViewById(R.id.studentsList);
		studentsList.setTextFilterEnabled(true);
		studentsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, students));
		studentsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,	long duration) {
				Intent intent = new Intent(StudentSelect.this, StudentDetails.class);
				CharSequence name = ((TextView)view).getText();
				
				intent.putExtra(Student.SELECTED_ID, name);
				startActivity(intent);
			}
		});
		
		Button btn = (Button) findViewById(R.id.NewStudentButton);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(v.getContext(), NewStudent.class));
			}
		});
	}
}
