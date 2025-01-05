package com.project.navigation;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MakananFragment extends Fragment {

    public MakananFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        setupNavigation(rootView);

        return rootView;
    }

    private void setupNavigation(View rootView) {
        Button semuakatButton = rootView.findViewById(R.id.semuakat);
        Button makankatButton = rootView.findViewById(R.id.makankat);
        Button minumkatButton = rootView.findViewById(R.id.minumkat);
        CardView menu = rootView.findViewById(R.id.menu);

        // Set navigations
        menu.setOnClickListener(v -> navigateToActivity(DetailMenuMakanan.class));
        semuakatButton.setOnClickListener(v -> navigateToFragment(new menuFragment()));
        makankatButton.setOnClickListener(v -> navigateToFragment(new MakananFragment()));
        minumkatButton.setOnClickListener(v -> navigateToFragment(new MinumanFragment()));
    }

    private void navigateToActivity(Class<?> targetActivity) {
        Intent intent = new Intent(getActivity(), targetActivity);
        startActivity(intent);
    }

    private void navigateToFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
