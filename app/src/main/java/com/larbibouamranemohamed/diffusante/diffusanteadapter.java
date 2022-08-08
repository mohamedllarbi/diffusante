package com.larbibouamranemohamed.diffusante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.nativead.NativeAd;





public class  diffusanteadapter extends FirebaseRecyclerAdapter<diffusantemodel , RecyclerView.ViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */



    public diffusanteadapter(@NonNull FirebaseRecyclerOptions<diffusantemodel> options ) {

        super(options);



    }

    // en cas il y'aura une erreure de remplissge va prendre ca comme item view
    public class emptyviewHolder extends RecyclerView.ViewHolder   {

        public emptyviewHolder(@NonNull View itemView) {
            super(itemView);




        }}


    // pub1
    public class AdviewHolder extends RecyclerView.ViewHolder   {
        TemplateView t;
        public AdviewHolder(@NonNull View itemView) {
            super(itemView);

            t= (TemplateView) itemView.findViewById(R.id.my_template);


        }}

    // pub2
    public class AdviewHolder2 extends RecyclerView.ViewHolder   {
        TemplateView t2;
        public AdviewHolder2(@NonNull View itemView) {
            super(itemView);

            t2= (TemplateView) itemView.findViewById(R.id.my_template2);


        }}

    // pub3
    public class AdviewHolder3 extends RecyclerView.ViewHolder   {
        TemplateView t3;
        public AdviewHolder3(@NonNull View itemView) {
            super(itemView);

            t3= (TemplateView) itemView.findViewById(R.id.my_template3);


        }}

   // la date des match
    public class dateviewHolder extends RecyclerView.ViewHolder   {
        TextView date;

        public dateviewHolder(@NonNull View itemView) {
            super(itemView);

            date= (TextView) itemView.findViewById(R.id.date);

        }}

        // la fiche des match heure ... equipes extera

    public class infoviewHolder extends RecyclerView.ViewHolder   {
        TextView equiped,equipee,time;
        ImageView chaineim,iconed,iconee,competitionim,chaineim2;

        public infoviewHolder(@NonNull View itemView) {
            super(itemView);


            equiped= (TextView) itemView.findViewById(R.id.equiped);
            equipee = (TextView) itemView.findViewById(R.id.equipext);
            time = (TextView) itemView.findViewById(R.id.heure);
            chaineim = (ImageView) itemView.findViewById(R.id.ch);
            chaineim2 = (ImageView) itemView.findViewById(R.id.ch2);
            iconed = (ImageView) itemView.findViewById(R.id.imaged);
            iconee = (ImageView) itemView.findViewById(R.id.imagee);
            competitionim = (ImageView) itemView.findViewById(R.id.comp);




        }}

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
                return new diffusanteadapter.dateviewHolder(view);
            case 1:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.principal,parent,false);
                return new diffusanteadapter.infoviewHolder(view1);
            case 2:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.nativeads,parent,false);
                return new diffusanteadapter.AdviewHolder(view2);

            case 3:
                View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.nativeads2,parent,false);
                return new diffusanteadapter.AdviewHolder2(view3);
            case 4:
                View view4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.nativeads3,parent,false);
                return new diffusanteadapter.AdviewHolder3(view4);

            case 5:
                View view5 = LayoutInflater.from(parent.getContext()).inflate(R.layout.empty,parent,false);
                return new diffusanteadapter.emptyviewHolder(view5);




        }
        return null;
    }

    // items position
    public int getItemViewType(int position) {
     if (getItem(position).date != null)
        return 0;
        if (getItem(position).getHeure() != null )
            return 1;
     if ( position == 7 )
         return 2;
        if ( position == 14 )
            return 3;
        if ( position == 26)
            return 4;
     else return 5;

    }


    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position, diffusantemodel model) {



        switch (holder.getItemViewType()) {


            case 0:
                dateviewHolder viewHolder = (dateviewHolder) holder;
                viewHolder.date.setText(model.getDate());


                break;
            case 1:

                infoviewHolder viewHolder1 = (infoviewHolder) holder;
                viewHolder1.equiped.setText(model.getEquiped());
                viewHolder1.equipee.setText(model.getEquipee());
                viewHolder1.time.setText(model.getHeure());
                Glide.with(( (infoviewHolder) holder ).iconed.getContext()).load(model.getIconed())
                        .into(( (infoviewHolder) holder ).iconed);
                Glide.with(( (infoviewHolder) holder ).iconee.getContext()).load(model.getIconee())
                        .into(( (infoviewHolder) holder ).iconee);
                Glide.with(( (infoviewHolder) holder ).chaineim.getContext()).load(model.getChaine())
                        .into(( (infoviewHolder) holder ).chaineim);
                Glide.with(( (infoviewHolder) holder ).chaineim2.getContext()).load(model.getChaine2())
                        .into(( (infoviewHolder) holder ).chaineim2);
                Glide.with(( (infoviewHolder) holder ).competitionim.getContext()).load(model.getCompetition())
                        .into(( (infoviewHolder) holder ).competitionim);


                break;
            case 2:
                AdviewHolder viewHolder2 = (AdviewHolder) holder;
                MobileAds.initialize(viewHolder2.itemView.getContext());
                AdLoader adLoader = new AdLoader.Builder(viewHolder2.itemView.getContext(), "ca-app-pub-7997855200099236/5081842306")
                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                            @Override
                            public void onNativeAdLoaded(NativeAd nativeAd) {
                                NativeTemplateStyle styles = new
                                        NativeTemplateStyle.Builder().build();
                                TemplateView t = viewHolder2.itemView.findViewById(R.id.my_template);
                                t.setStyles(styles);
                                t.setNativeAd(nativeAd);
                            }
                        })
                        .build();

                adLoader.loadAd(new AdRequest.Builder().build());break;


            case 3:
                AdviewHolder2 viewHolder3 = (AdviewHolder2) holder;
                MobileAds.initialize(viewHolder3.itemView.getContext());
                AdLoader adLoader2 = new AdLoader.Builder(viewHolder3.itemView.getContext(), "ca-app-pub-7997855200099236/1575310748")
                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                            @Override
                            public void onNativeAdLoaded(NativeAd nativeAd) {
                                NativeTemplateStyle styles = new
                                        NativeTemplateStyle.Builder().build();
                                TemplateView t = viewHolder3.itemView.findViewById(R.id.my_template2);
                                t.setStyles(styles);
                                t.setNativeAd(nativeAd);
                            }
                        })
                        .build();

                adLoader2.loadAd(new AdRequest.Builder().build());break;

            case 4:
                AdviewHolder3 viewHolder4 = (AdviewHolder3) holder;
                MobileAds.initialize(viewHolder4.itemView.getContext());
                AdLoader adLoader3 = new AdLoader.Builder(viewHolder4.itemView.getContext(), "ca-app-pub-7997855200099236/8802407533")
                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                            @Override
                            public void onNativeAdLoaded(NativeAd nativeAd) {
                                NativeTemplateStyle styles = new
                                        NativeTemplateStyle.Builder().build();
                                TemplateView t = viewHolder4.itemView.findViewById(R.id.my_template3);
                                t.setStyles(styles);
                                t.setNativeAd(nativeAd);
                            }
                        })
                        .build();

                adLoader3.loadAd(new AdRequest.Builder().build());break;

            case 5:
                emptyviewHolder viewHolder5 = (emptyviewHolder) holder;


                break;


        } }
    @Override
    public void onDataChanged() {
        super.onDataChanged();
        diffusantehome.disableIt();
    }


}

