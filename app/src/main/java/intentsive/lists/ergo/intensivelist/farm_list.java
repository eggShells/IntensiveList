package intentsive.lists.ergo.intensivelist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ericd_000 on 1/7/2017.
 */
//singleton representing list of entries
public class farm_list {

    private static farm_list sFarmList;
    private ArrayList<listModel> entryArray;

    public farm_list(Context context){

        entryArray = new ArrayList<>();

        for(int i=0;i<100;i++){
            listModel farm = new listModel();
            farm.setfarm_name("farm " + i);
            if (i % 2 == 0)
                farm.setFarm_city("york");
            else
                farm.setFarm_city("lancaster");
            entryArray.add(farm);
        }

    }

    public static farm_list get(Context context){
        if (sFarmList == null)
            sFarmList = new farm_list(context);
        return sFarmList;
    }

    public listModel getFarm(String farm){
        return null;
    }

    public ArrayList<listModel> getFarmList(){
        return entryArray;
    }
}
