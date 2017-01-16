package intentsive.lists.ergo.intensivelist;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;

/**
 * Created by ericd_000 on 1/7/2017.
 */

public class FarmListActivity extends AbstractFragmentActivityWithAsync{

    @Override
    protected Fragment createFragment() {
        return new FarmListFragment();
//        return new ListFragment();
//        return new CalendarLayout();
    }


}
