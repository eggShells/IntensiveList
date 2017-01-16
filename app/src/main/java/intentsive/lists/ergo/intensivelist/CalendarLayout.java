package intentsive.lists.ergo.intensivelist;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by ericd_000 on 1/7/2017.
 */

public class CalendarLayout extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    ListView monday;
    ListView tuesday;
    ListView wednes;
    ListView thurs;
    ListView fri;
    SimpleCursorAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.linear_calendar, container, false);
        int[] toViews = new int[]{R.id.date, R.id.item};
        String[] fromCols = {ContactsContract.Data.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
        monday = (ListView) v.getRootView().findViewById(R.id.monday);
        tuesday = (ListView) v.getRootView().findViewById(R.id.tuesday);
        wednes = (ListView) v.getRootView().findViewById(R.id.wednesday);
        thurs = (ListView) v.getRootView().findViewById(R.id.thursday);
        fri = (ListView) v.getRootView().findViewById(R.id.friday);
        mAdapter = new SimpleCursorAdapter(this.getContext(), R.layout.week_view,null,fromCols,toViews,0);
        monday.setAdapter(mAdapter);
//        tuesday.setAdapter(mAdapter);
        getLoaderManager().initLoader(0,null,this);

        return v;
    }

    // These are the Contacts rows that we will retrieve.
    static final String[] CONTACTS_SUMMARY_PROJECTION = new String[] {
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
//            ContactsContract.Contacts.CONTACT_STATUS,
//            ContactsContract.Contacts.CONTACT_PRESENCE,
//            ContactsContract.Contacts.PHOTO_ID,
//            ContactsContract.Contacts.LOOKUP_KEY,
    };

    public Loader<Cursor> onCreateLoader(int id, Bundle args){
        Uri baseUri;
        String mCurFilter = null;
        if (mCurFilter != null) {
            baseUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI,
                    Uri.encode(mCurFilter));
        } else {
            baseUri = ContactsContract.Contacts.CONTENT_URI;
        }

        // Now create and return a CursorLoader that will take care of
        // creating a Cursor for the data being displayed.
        String select = "((" + ContactsContract.Contacts.DISPLAY_NAME + " NOTNULL) AND ("
                + ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1) AND ("
                + ContactsContract.Contacts.DISPLAY_NAME + " != '' ))";
        return new CursorLoader(getActivity(), baseUri,
                CONTACTS_SUMMARY_PROJECTION, select, null,
                ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");


    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null)
                Log.d("KK", String.valueOf(data.getColumnNames()));

        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
