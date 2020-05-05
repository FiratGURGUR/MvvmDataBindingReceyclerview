package com.example.mvvmpattern.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmpattern.api.MyApi;
import com.example.mvvmpattern.api.MyClient;
import com.example.mvvmpattern.model.Hero;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//NO LIVEDATA
public class HeroViewModel extends ViewModel {
    public String name="";
    public String realname="";
    public String team="";
    public String firstappearance="";
    public String createdby="";
    public String publisher="";
    public String imageurl="";
    public String bio="";
    public MutableLiveData<List<HeroViewModel>> mutableLiveData = new MutableLiveData<>();
    public List<HeroViewModel> list;
    private List<Hero> heroList;

    public String getImageurl(){
        return imageurl;
    }

    @BindingAdapter({"imageurl"})
    public static void loadimage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext()).load(imageUrl).apply(RequestOptions.circleCropTransform()).into(imageView);
    }

    public HeroViewModel(){
    }

    public HeroViewModel(Hero hero){
        this.name=hero.name;
        this.realname=hero.realname;
        this.team=hero.team;
        this.firstappearance=hero.firstappearance;
        this.createdby=hero.createdby;
        this.publisher=hero.publisher;
        this.imageurl=hero.imageurl;
        this.bio=hero.bio;
    }

    public MutableLiveData<List<HeroViewModel>> getMutableLiveData(){
        list=new ArrayList<>();
        MyApi api= MyClient.getInstance().getMyApi();
        Call<List<Hero>>call=api.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                heroList=new ArrayList<>();
                heroList=response.body();
                for (int i=0; i<heroList.size(); i++){
                    Hero myk=heroList.get(i);
                    HeroViewModel myListViewModel=new HeroViewModel(myk);
                    list.add(myListViewModel);
                    mutableLiveData.setValue(list);
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }



}
