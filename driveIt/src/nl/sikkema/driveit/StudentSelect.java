package nl.sikkema.driveit;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class StudentSelect extends Activity {

//	private static String[] students = {"Jan", "Paul", "Hendrik", "Peter", "Mike", "Anita", "Berber", "Chantal", "Rutger", "Auke", "Diana", "Henk"};
	private ListView studentsList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_select);
		
		String[] projection = new String[] {Contacts.DISPLAY_NAME};
		Uri contacts = Contacts.CONTENT_URI;
		
		List<String> students = new ArrayList<String>(); 
		Cursor cur = managedQuery(contacts, projection, null, null, null);
		if(cur.moveToFirst()) {
			int displayNameIndex = cur.getColumnIndex(Contacts.DISPLAY_NAME);
			String name = cur.getString(displayNameIndex);
			students.add(name);
		}
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
