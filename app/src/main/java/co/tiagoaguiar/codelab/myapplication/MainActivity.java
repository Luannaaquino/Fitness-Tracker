package co.tiagoaguiar.codelab.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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

		List<MainItem> mainItems = new ArrayList<>();
		mainItems.add(new MainItem(1, R.drawable.ic_baseline_wb_sunny_24, R.string.Label_imc, Color.GREEN));
		mainItems.add(new MainItem(2, R.drawable.ic_baseline_remove_red_eye_24, R.string.Label_tmb, Color.YELLOW));


		rvMain.setLayoutManager(new LinearLayoutManager(this));

		MainAdapter adapter = new MainAdapter(mainItems);
		rvMain.setAdapter(adapter);
	}
	private class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

		private List<MainItem> mainItems;

		public MainAdapter(List<MainItem> mainItems){
			this.mainItems = mainItems;
		}

		@NonNull
		@Override
		public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
			return new MainViewHolder(getLayoutInflater().inflate(R.layout.main_item, parent, false ));
		}

		@Override
		public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
			MainItem mainItemCurrent = mainItems.get(position);
			holder.bind(mainItemCurrent);
		}

		@Override
		public int getItemCount() {
			return mainItems.size();
		}
	}

	private class MainViewHolder extends RecyclerView.ViewHolder{

		public MainViewHolder(@NonNull View itemView) {
			super(itemView);
		}
		public void bind(MainItem item){
			TextView txtName = itemView.findViewById(R.id.item_txt_name);
			ImageView imgIcon = itemView.findViewById(R.id.item_img_icon);
			LinearLayout container = (LinearLayout) itemView;

			txtName.setText(item.getTextStringId());
			imgIcon.setImageResource(item.getDrawableId());
			container.setBackgroundColor(item.getColor());
		}
	}
}