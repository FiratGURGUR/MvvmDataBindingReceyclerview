package com.example.mvvmpattern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmpattern.R;
import com.example.mvvmpattern.databinding.HeroBinding;
import com.example.mvvmpattern.viewmodel.HeroViewModel;


import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.ViewHolder> {
    private List<HeroViewModel> arrayList;
    private Context context;
    private LayoutInflater layoutInflater;

    public HeroAdapter(List<HeroViewModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        HeroBinding heroBinding= DataBindingUtil.inflate(layoutInflater, R.layout.recyler_item,parent,false);
        return new ViewHolder(heroBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HeroViewModel myListViewModel=arrayList.get(position);
        holder.bind(myListViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private HeroBinding heroBinding;
        public ViewHolder(@NonNull HeroBinding heroBinding) {
            super(heroBinding.getRoot());
            this.heroBinding=heroBinding;
        }
        public void bind(HeroViewModel hero){
            this.heroBinding.setHero(hero);
            heroBinding.executePendingBindings();
        }
        public HeroBinding getHeroBinding(){
            return heroBinding;
        }
    }


}
