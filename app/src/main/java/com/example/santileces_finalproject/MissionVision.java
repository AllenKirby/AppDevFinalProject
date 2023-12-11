package com.example.santileces_finalproject;

import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.annotation.TargetApi;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MissionVision extends Fragment {
    private RecyclerView recyclerView;
    private LUMVAdapter MVAdapter;
    private List missionVision =new ArrayList<>();
    @TargetApi(Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mission_vision, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        MVAdapter=new LUMVAdapter(missionVision);
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(MVAdapter);
        LUMV();

        return view;
    }
    private void LUMV() {
        LUMV data=new LUMV("Mission", "Laguna University is committed to produce academically prepared and technically skilled individuals who are socially and morally upright.");
        missionVision.add(data);
        data=new LUMV("Vision", "Laguna University shall be a socially responsive educational institution of choice providing holistically developed individuals in the Asia-Pacific Region.");
        missionVision.add(data);
    }
}