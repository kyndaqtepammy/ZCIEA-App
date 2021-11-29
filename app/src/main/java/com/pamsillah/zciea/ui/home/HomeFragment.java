package com.pamsillah.zciea.ui.home;

import static com.pamsillah.zciea.config.Config.ACTIVE;
import static com.pamsillah.zciea.config.Config.EVENTS;
import static com.pamsillah.zciea.config.Config.IMPORT;
import static com.pamsillah.zciea.config.Config.INACTIVE;
import static com.pamsillah.zciea.config.Config.NEW_MEMBER;
import static com.pamsillah.zciea.config.Config.REPORTS;
import static com.pamsillah.zciea.config.Config.SETTINGS;
import static com.pamsillah.zciea.config.Config.SYSTEM_USERS;
import static com.pamsillah.zciea.config.Config.TARGETED_SMS;
import static com.pamsillah.zciea.config.Config.TERRITORIES;
import static com.pamsillah.zciea.config.Config.VIEW_MEMBER;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pamsillah.zciea.R;
import com.pamsillah.zciea.adapters.AdapterHomeMenu;
import com.pamsillah.zciea.databinding.FragmentHomeBinding;
import com.pamsillah.zciea.models.ModelHomeMenu;
import com.pamsillah.zciea.config.Config;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private RecyclerView homeMenuRecycler;
    private ArrayList<ModelHomeMenu> modelHomeMenuArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeMenuRecycler = root.findViewById(R.id.rv_home_menu);
        modelHomeMenuArrayList = new ArrayList<>();
        modelHomeMenuArrayList.add(new ModelHomeMenu("View Members", R.drawable.ic_baseline_person_24, VIEW_MEMBER));
        modelHomeMenuArrayList.add(new ModelHomeMenu("New Members", R.drawable.ic_baseline_person_add_24, NEW_MEMBER));
        modelHomeMenuArrayList.add(new ModelHomeMenu("Territories", R.drawable.ic_baseline_group_work_24, TERRITORIES));
        modelHomeMenuArrayList.add(new ModelHomeMenu("Active", R.drawable.ic_baseline_check_box_24, ACTIVE));
        modelHomeMenuArrayList.add(new ModelHomeMenu("Inactive", R.drawable.ic_baseline_cancel_24, INACTIVE));
        modelHomeMenuArrayList.add(new ModelHomeMenu("Reports", R.drawable.ic_baseline_show_chart_24, REPORTS));
        modelHomeMenuArrayList.add(new ModelHomeMenu("Settings", R.drawable.ic_baseline_settings_24, SETTINGS));
        modelHomeMenuArrayList.add(new ModelHomeMenu("Events", R.drawable.ic_baseline_event_24, EVENTS));
        modelHomeMenuArrayList.add(new ModelHomeMenu("Import", R.drawable.ic_baseline_import_export_24, IMPORT));
        modelHomeMenuArrayList.add(new ModelHomeMenu("System Users", R.drawable.ic_baseline_person_24, SYSTEM_USERS));
        modelHomeMenuArrayList.add(new ModelHomeMenu("Targeted SMS", R.drawable.ic_baseline_textsms_24, TARGETED_SMS));

        AdapterHomeMenu adapterHomeMenu = new AdapterHomeMenu(modelHomeMenuArrayList, getActivity());
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        homeMenuRecycler.setLayoutManager(layoutManager);
        homeMenuRecycler.setAdapter(adapterHomeMenu);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}