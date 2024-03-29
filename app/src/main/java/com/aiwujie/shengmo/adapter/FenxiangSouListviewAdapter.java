package com.aiwujie.shengmo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aiwujie.shengmo.R;
import com.aiwujie.shengmo.bean.AtsouBean;
import com.aiwujie.shengmo.utils.GlideImgManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.aiwujie.shengmo.http.HttpUrl.NetPic;

/**
 * Created by 290243232 on 2016/12/17.
 */
public class FenxiangSouListviewAdapter extends BaseAdapter {
    private Context context;
    private List<AtsouBean.DataBean> list;
    private LayoutInflater inflater;
    Handler handler = new Handler();

    public FenxiangSouListviewAdapter(Context context, List<AtsouBean.DataBean> list) {
        super();
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_at_listview, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        AtsouBean.DataBean data = list.get(position);
        if ("".equals(data.getHead_pic()) || NetPic().equals(data.getHead_pic())) {//"http://59.110.28.150:888/"
            holder.itemAtListviewIcon.setImageResource(R.mipmap.morentouxiang);
        } else {
            GlideImgManager.glideLoader(context, data.getHead_pic(), R.mipmap.morentouxiang, R.mipmap.morentouxiang, holder.itemAtListviewIcon, 0);
        }
        holder.itemAtListviewSex.setText(data.getAge());
      /*  if (data.getUserInfo().getOnlinestate() == 0) {
            holder.itemAtListviewOnline.setVisibility(View.GONE);
        } else {
            holder.itemAtListviewOnline.setVisibility(View.VISIBLE);
        }*/
        //  判断显示标识，志愿者>官方管理>年svip>svip>年vip>vip
       // UserIdentityUtils.showIdentity(context,data.getHead_pic(),data.getUid(),data.getUserInfo().getIs_volunteer(),data.getUserInfo().getIs_admin(),data.getUserInfo().getSvipannual(),data.getUserInfo().getSvip(),data.getUserInfo().getVipannual(),data.getUserInfo().getVip(),holder.itemAtListviewVip);

        /*if (data.getUserInfo().getIs_hand().equals("0")) {
            holder.itemAtListviewHongiang.setVisibility(View.INVISIBLE);
        } else {
            holder.itemAtListviewHongiang.setVisibility(View.VISIBLE);
        }*/
        if (data.getRealname().equals("0")) {
            holder.itemAtListviewShiming.setVisibility(View.GONE);
        } else {
            holder.itemAtListviewShiming.setVisibility(View.VISIBLE);
        }

        if (data.getSex().equals("1")) {
            holder.itemAtListviewSex.setBackgroundResource(R.drawable.item_sex_nan_bg);
            Drawable drawable = context.getResources().getDrawable(R.mipmap.nan);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            holder.itemAtListviewSex.setCompoundDrawables(drawable, null, null, null);
        } else if (data.getSex().equals("2")) {
            holder.itemAtListviewSex.setBackgroundResource(R.drawable.item_sex_nv_bg);
            Drawable drawable = context.getResources().getDrawable(R.mipmap.nv);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            holder.itemAtListviewSex.setCompoundDrawables(drawable, null, null, null);
        } else if (data.getSex().equals("3")) {
            holder.itemAtListviewSex.setBackgroundResource(R.drawable.item_sex_san_bg);
            Drawable drawable = context.getResources().getDrawable(R.mipmap.san);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            holder.itemAtListviewSex.setCompoundDrawables(drawable, null, null, null);
        }
        if (data.getRole().equals("S")) {
            holder.itemAtListviewRole.setBackgroundResource(R.drawable.item_sex_nan_bg);
            holder.itemAtListviewRole.setText("斯");
        } else if (data.getRole().equals("M")) {
            holder.itemAtListviewRole.setBackgroundResource(R.drawable.item_sex_nv_bg);
            holder.itemAtListviewRole.setText("慕");
        } else if (data.getRole().equals("SM")) {
            holder.itemAtListviewRole.setBackgroundResource(R.drawable.item_sex_san_bg);
            holder.itemAtListviewRole.setText("双");
        }else if(data.getRole().equals("~")){
            holder.itemAtListviewRole.setBackgroundResource(R.drawable.item_sex_lang_bg);
            holder.itemAtListviewRole.setText("~");
        }

        holder.itemAtListviewFlag.setVisibility(View.GONE);
        holder.itemAtListviewName.setText(data.getNickname());
        //holder.itemAtListviewCity.setText(data.getUserInfo().getCity());
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.item_at_listview_icon)
        ImageView itemAtListviewIcon;
        @BindView(R.id.item_at_listview_hongiang)
        ImageView itemAtListviewHongiang;
        @BindView(R.id.item_at_listview_vip)
        ImageView itemAtListviewVip;
        @BindView(R.id.item_at_listview_name)
        TextView itemAtListviewName;
        @BindView(R.id.item_at_listview_shiming)
        ImageView itemAtListviewShiming;
        @BindView(R.id.item_at_listview_online)
        ImageView itemAtListviewOnline;
        @BindView(R.id.item_at_listview_Sex)
        TextView itemAtListviewSex;
        @BindView(R.id.item_at_listview_role)
        TextView itemAtListviewRole;
        @BindView(R.id.item_at_listview_city)
        TextView itemAtListviewCity;
        @BindView(R.id.item_at_listview_flag)
        ImageView itemAtListviewFlag;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}


