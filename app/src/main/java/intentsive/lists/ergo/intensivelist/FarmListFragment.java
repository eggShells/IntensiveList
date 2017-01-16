package intentsive.lists.ergo.intensivelist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ericd_000 on 1/7/2017.
 */
public class FarmListFragment extends Fragment{

    private RecyclerView farmRecycles;
    FarmAdapter viewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farm_list, container, false);
        farmRecycles = (RecyclerView) view.findViewById(R.id.farm_recycler_view);

        farmRecycles.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {

        farm_list myList = farm_list.get(getActivity());
        List<listModel> farmModel = myList.getFarmList();
        viewAdapter = new FarmAdapter(farmModel);
        farmRecycles.setAdapter(viewAdapter);

    }

    private class FarmHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView farmName;
        public TextView farmCity;
        public CheckBox organixCB;
        private listModel listItem;

        public FarmHolder(View itemView) {
            super(itemView);
            farmName = (TextView) itemView.findViewById(R.id.list_item_farm_name);
            farmCity = (TextView) itemView.findViewById(R.id.list_item_farm_city);
            organixCB = (CheckBox) itemView.findViewById(R.id.list_item_oragnic_cb);
            farmName.setOnClickListener(this);
        }

        public void bindFarm(listModel lm){
            listItem = lm;
            farmName.setText(listItem.getfarm_name());
            farmCity.setText(listItem.getFarm_city());
            farmCity.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
            organixCB.setChecked(true);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(),listItem.getFarm_city() + "clicked here", Toast.LENGTH_SHORT).show();
        }
    }

    private class FarmAdapter extends RecyclerView.Adapter<FarmHolder>{

        private List<listModel> farmList;

        public FarmAdapter(List<listModel> farmModel) {
            farmList = farmModel;
        }

        @Override
        public FarmHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflat = LayoutInflater.from(getActivity());
//            View myView = layoutInflat.inflate(android.R.layout.simple_list_item_1, parentx`, false);
            View myView = layoutInflat.inflate(R.layout.list_farm_item, parent, false);
            return new FarmHolder(myView);
        }

        @Override
        public void onBindViewHolder(FarmHolder holder, int position) {

            listModel lm = farmList.get(position);
            holder.bindFarm(lm);
//            holder.farmName.setText(lm.getfarm_name());
        }

        @Override
        public int getItemCount() {
            return farmList.size();
        }
    }
}
