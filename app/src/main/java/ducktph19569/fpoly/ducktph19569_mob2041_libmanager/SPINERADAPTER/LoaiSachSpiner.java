package ducktph19569.fpoly.ducktph19569_mob2041_libmanager.SPINERADAPTER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPPRODUCT.LoaiSach;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.R;

public class LoaiSachSpiner extends ArrayAdapter<LoaiSach> {
    Context context;
    ArrayList<LoaiSach> list;

    public LoaiSachSpiner(@NonNull Context context, ArrayList<LoaiSach> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.custom_spiner_loais, null);
        }
        LoaiSach loaiSach = list.get(position);
        if (loaiSach != null) {
            TextView tv_ls = view.findViewById(R.id.tv_tenloaisach);
            tv_ls.setText(loaiSach.getTenLS());
        }
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable @org.jetbrains.annotations.Nullable View convertView, @NonNull @NotNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.custom_spiner_loais, null);
        }
        LoaiSach loaiSach = list.get(position);
        if (loaiSach != null) {
            TextView tv_ls = view.findViewById(R.id.tv_tenloaisach);
            tv_ls.setText(loaiSach.getTenLS());
        }
        return view;

    }
}
