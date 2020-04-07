package com.mahmoudsallam.task.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoudsallam.task.R;
import com.mahmoudsallam.task.data.model.api.UsersResponse;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {
    private Context mContext;
    private List<UsersResponse> users;
    private MainNavigator mainNavigator;

    public UsersAdapter(Context mContext, List<UsersResponse> users, MainNavigator mainNavigator) {
        this.mContext = mContext;
        this.users = users;
        this.mainNavigator = mainNavigator;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_user, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        UsersResponse user = users.get(position);

        holder.nameText.setText(user.getName());
        holder.addressText.setText(user.getAddress().toString());
        holder.phoneText.setText(user.getPhone());
        holder.itemView.setOnClickListener(v -> {
            mainNavigator.showUserDetails(user);
        });


    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class UsersViewHolder extends RecyclerView.ViewHolder {
        private TextView nameText, addressText, phoneText;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.name_text);
            addressText = itemView.findViewById(R.id.address_text);
            phoneText = itemView.findViewById(R.id.phone_text);
        }
    }
}
