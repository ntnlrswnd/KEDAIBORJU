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
 * Use the {@link menuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class menuFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public menuFragment() {
        // Required empty public constructor
    }

    public static menuFragment newInstance(String param1, String param2) {
        menuFragment fragment = new menuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        // Find the buttons and cardview by ID
        Button semuakatButton = rootView.findViewById(R.id.semuakat);
        Button makankatButton = rootView.findViewById(R.id.makankat);
        Button minumkatButton = rootView.findViewById(R.id.minumkat);
        CardView menu = rootView.findViewById(R.id.menu);

        // Set OnClickListener for menu CardView to navigate to DetailMenuMakanan
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to start a new activity for the CardView
                Intent intent = new Intent(getActivity(), DetailMenuMakanan.class);
                startActivity(intent);
            }
        });

        // Set OnClickListener for semuakatButton to navigate to menuFragment
        semuakatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuFragment menuFrag = new menuFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, menuFrag);
                transaction.addToBackStack(null);  // Add transaction to back stack
                transaction.commit();
            }
        });

        // Set OnClickListener for makankatButton to navigate to MakananFragment
        makankatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakananFragment makananFrag = new MakananFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, makananFrag);
                transaction.addToBackStack(null);  // Add transaction to back stack
                transaction.commit();
            }
        });

        // Set OnClickListener for minumkatButton to navigate to MinumanFragment
        minumkatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MinumanFragment minumanFrag = new MinumanFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.flFragment, minumanFrag);
                transaction.addToBackStack(null);  // Add transaction to back stack
                transaction.commit();
            }
        });

        return rootView;
    }

}
