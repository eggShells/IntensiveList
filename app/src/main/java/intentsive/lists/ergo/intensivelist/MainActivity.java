package intentsive.lists.ergo.intensivelist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AbstractFragmentActivityWithAsync {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_container);
//
//        FragmentManager myFM = getSupportFragmentManager();
//        Fragment listFrag = myFM.findFragmentById(R.id.fragment_container);
//
//        if (listFrag == null){
//            listFrag = new ListFragment();
//            myFM.beginTransaction().add(R.id.fragment_container, listFrag).commit();
//        }
//    }

    @Override
    protected Fragment createFragment() {

        return new ListFragment();
    }
}
