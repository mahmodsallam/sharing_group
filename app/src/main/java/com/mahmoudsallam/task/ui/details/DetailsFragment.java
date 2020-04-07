package com.mahmoudsallam.task.ui.details;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.mahmoudsallam.task.R;
import com.mahmoudsallam.task.data.model.api.UsersResponse;
import com.mahmoudsallam.task.ui.main.MainFragment;

public class DetailsFragment extends Fragment {

    private TextView nameText, userNameText, emailText, addressText, phoneText, website, company;
    private ImageView backImg;

    public static DetailsFragment newInstance() {
        Bundle args = new Bundle();
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        nameText = view.findViewById(R.id.name_text);
        userNameText = view.findViewById(R.id.username_text);
        emailText = view.findViewById(R.id.email_text);
        addressText = view.findViewById(R.id.address_text);
        phoneText = view.findViewById(R.id.phone_text);
        website = view.findViewById(R.id.website_text);
        company = view.findViewById(R.id.company_text);
        UsersResponse user = this.getArguments().getParcelable("USER_DETAILS");
        nameText.setText(user.getName());
        userNameText.setText(user.getUsername());
        emailText.setText(user.getEmail());
        addressText.setText(user.getAddress().toString());
        phoneText.setText(user.getPhone());
        website.setText(user.getWebsite());
        company.setText(user.getCompany().getName());
        backImg = view.findViewById(R.id.back_img);
        backImg.setOnClickListener(v -> {
            Navigation.findNavController(v)
                    .popBackStack(R.id.mainFragment, false);
        });
        return view;
    }


}
