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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MinumanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MinumanFragment extends Fragment {

        public static MinumanFragment newInstance(String param1, String param2) {
            MinumanFragment fragment = new MinumanFragment();
            Bundle args = new Bundle();
            args.putString("param1", param1);
            args.putString("param2", param2);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

            Button semuakatButton = rootView.findViewById(R.id.semuakat);
            Button makankatButton = rootView.findViewById(R.id.makankat);
            Button minumkatButton = rootView.findViewById(R.id.minumkat);
            CardView menu = rootView.findViewById(R.id.menu);

            // Navigasi ke DetailMenuMakanan saat CardView diklik
            menu.setOnClickListener(v -> {
                Intent intent = new Intent(getActivity(), DetailMenuMakanan.class);
                startActivity(intent);
            });

            // Navigasi ke MenuFragment
            semuakatButton.setOnClickListener(v -> {
                menuFragment menuFrag = new menuFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, menuFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            });

            // Navigasi ke MakananFragment
            makankatButton.setOnClickListener(v -> {
                MakananFragment makananFrag = new MakananFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, makananFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            });

            // Navigasi ke MinumanFragment
            minumkatButton.setOnClickListener(v -> {
                MinumanFragment minumanFrag = new MinumanFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, minumanFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            });

            return rootView;
        }
}