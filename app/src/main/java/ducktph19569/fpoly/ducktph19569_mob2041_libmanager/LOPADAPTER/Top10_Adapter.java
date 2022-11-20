package ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPADAPTER;

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

import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPPRODUCT.Top;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.QuanlyvsThongke.Thongketo10Fragment;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.R;

public class Top10_Adapter extends ArrayAdapter<Top> {
    Context context;
    Thongketo10Fragment fragment;
    ArrayList<Top> list;

    public Top10_Adapter(@NonNull @NotNull Context context, Thongketo10Fragment fragment, ArrayList<Top> list) {
        super(context, 0, list);
        this.context = context;
        this.fragment = fragment;
        this.list = list;
    }

    TextView tv_tenstk, tv_sltk;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_thongke, null);
        }
        Top top = list.get(position);
        if (top != null) {
            tv_tenstk = view.findViewById(R.id.tv_tensachtk);
            tv_tenstk.setText("Sách: " + top.tensach);
            tv_sltk = view.findViewById(R.id.tv_slouongtk);
            tv_sltk.setText("Số Lượng " + top.soluong);
        }

        return view;
    }
}
