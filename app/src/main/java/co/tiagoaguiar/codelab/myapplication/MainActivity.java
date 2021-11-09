package co.tiagoaguiar.codelab.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

	// private View btnImc;
		private RecyclerView rvMain;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	//	btnImc = findViewById(R.id.button_imc);
	//	btnImc.setOnClickListener(new View.OnClickListener() {
	//		@Override
	//		public void onClick(View view) {
	//			Intent intent = new Intent(MainActivity.this, ImcActivity.class);
	//			startActivity(intent);
	//		}
	//	});

		rvMain = findViewById(R.id.main_rv);
		rvMain.setLayoutManager(new LinearLayoutManager(this));

		MainAdapter adapter = new MainAdapter();
		rvMain.setAdapter(adapter);
	}
	private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

		@NonNull
		@Override
		public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false ));
		}

		@Override
		public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

		}

		@Override
		public int getItemCount() {
			return 15;
		}
	}

	private class MainViewHolder extends RecyclerView.ViewHolder{

		public MainViewHolder(@NonNull View itemView) {
			super(itemView);
		}
	}
}