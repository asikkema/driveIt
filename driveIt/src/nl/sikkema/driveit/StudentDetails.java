package nl.sikkema.driveit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class StudentDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_details);
		String studentName = getIntent().getStringExtra(Student.SELECTED_ID);
		TextView tv = (TextView) findViewById(R.id.StudentNameTextView);
		tv.setText(studentName);
	}
}
