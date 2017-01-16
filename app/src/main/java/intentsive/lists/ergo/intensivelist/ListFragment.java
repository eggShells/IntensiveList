package intentsive.lists.ergo.intensivelist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ericd_000 on 1/2/2017.
 */

public class ListFragment extends Fragment {

    private listModel currentLM;
    private EditText farm_name;
    private EditText farm_address;
    private EditText farm_city;
    private Button submit;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        currentLM = new listModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View v = inflater.inflate(R.layout.list_linear, container, false);
        return v;
    }


}
