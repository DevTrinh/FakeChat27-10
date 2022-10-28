package com.fakechat.adapters;

import static com.fakechat.utils.Contains.FIRST_VIEW_SHORTCUT;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fakechat.R;
import com.fakechat.interfaces.OnClickWithPosition;
import com.fakechat.models.items.ItemShortcut;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuickShortcutAdapter extends RecyclerView.Adapter {

    private List<ItemShortcut> listShortcut = new ArrayList<>();
    private OnClickWithPosition onClickWithPosition;

    public QuickShortcutAdapter(List<ItemShortcut> listShortcut,
                                OnClickWithPosition onClickWithPosition) {
        this.listShortcut = listShortcut;
        this.onClickWithPosition = onClickWithPosition;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == FIRST_VIEW_SHORTCUT){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first_shortcut, parent, false);
            return new ItemFirstShortcutViewHolder(view);
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_circle_shortcut, parent,false);
            return new ItemShortcutViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemShortcut itemShortcut = listShortcut.get(position);
        switch (holder.getItemViewType()){
            case 0:
                ItemFirstShortcutViewHolder viewHolderFirst = (ItemFirstShortcutViewHolder) holder;
                viewHolderFirst.ivFirstShortcut.setImageResource(itemShortcut.getDrawableShortcut());
                viewHolderFirst.tvShortcutName.setText(itemShortcut.getNameShortcut());
                break;
            case 1:
                ItemShortcutViewHolder viewHolder = (ItemShortcutViewHolder) holder;
                viewHolder.ivShortcut.setImageResource(itemShortcut.getDrawableShortcut());
                viewHolder.tvShortcutName.setText(itemShortcut.getNameShortcut());
                if (itemShortcut.isOnline()){
                    viewHolder.ivOnline.setVisibility(View.VISIBLE);
                } else {
                    viewHolder.ivOnline.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (listShortcut != null){
            return listShortcut.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        ItemShortcut itemShortcut = listShortcut.get(position);
        if (itemShortcut.isFirst()){
            return FIRST_VIEW_SHORTCUT;
        }
        return 1;
    }

    public static class ItemShortcutViewHolder extends RecyclerView.ViewHolder{
        public final CircleImageView ivShortcut;
        private final TextView tvShortcutName;
        private final ImageView ivOnline;
        public ItemShortcutViewHolder(@NonNull View itemView) {
            super(itemView);
            ivOnline = itemView.findViewById(R.id.iv_online);
            tvShortcutName = itemView.findViewById(R.id.tv_name_shortcut);
            ivShortcut = itemView.findViewById(R.id.iv_item_shortcut);
        }
    }

    public static class ItemFirstShortcutViewHolder extends RecyclerView.ViewHolder{
        private final CircleImageView ivFirstShortcut;
        private final TextView tvShortcutName;
        public ItemFirstShortcutViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFirstShortcut = itemView.findViewById(R.id.iv_item_first_shortcut);
            tvShortcutName = itemView.findViewById(R.id.tv_name_shortcut);
        }
    }
}
