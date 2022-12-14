package ducktph19569.fpoly.ducktph19569_mob2041_libmanager.Taonv;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPADAPTER.Nv_Adapter;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPDAO.NVDao;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPPRODUCT.NhanVien;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.R;

public class Signup extends Fragment {
    NVDao dao;
    EditText edUser, edPass, edEnPass, edhoten;
    ListView lv_nv;
    FloatingActionButton flb_nv;
    Nv_Adapter adapter;
    List<NhanVien> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.singup_activity, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv_nv = view.findViewById(R.id.lisv_taoidnv);
        dao = new NVDao(getActivity());
        dao.OPEN();
        list = new ArrayList<>();
        list = dao.GETNV();
        adapter = new Nv_Adapter(list, getContext());
        lv_nv.setAdapter(adapter);

        flb_nv = view.findViewById(R.id.flonv);
        flb_nv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater layoutInflater = getLayoutInflater();
                View view = layoutInflater.inflate(R.layout.custom_taonv, null);
                builder.setView(view);
                dao = new NVDao(getActivity());
                edUser = view.findViewById(R.id.edUser);
                edhoten = view.findViewById(R.id.edHoTen);
                edPass = view.findViewById(R.id.edPass);
                edEnPass = view.findViewById(R.id.edRePass);
                builder.setTitle("                T???o T??i Kho???n");
                builder.setPositiveButton("T???o", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        NhanVien nhanVien = new NhanVien();
                        nhanVien.setMaNV(edUser.getText().toString());
                        nhanVien.setHoTen(edhoten.getText().toString());
                        nhanVien.setMaKhau(edPass.getText().toString());
                        if (checkrong() > 0) {
                            long kq = dao.ADDNV(nhanVien);
                            if (kq > 0) {
                                Toast.makeText(getActivity(), "T???o T??i kho???n th??nh c??ng", Toast.LENGTH_SHORT).show();
                                edUser.setText("");
                                edhoten.setText("");
                                edPass.setText("");
                                edEnPass.setText("");
                                list.clear();
                                list.addAll(dao.GETNV());
                                adapter.notifyDataSetChanged();
                            } else {
                                Toast.makeText(getActivity(), "T???o t??i kho???n th???t b???i", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Tho??t", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
        });

    }


    public int checkrong() {
        int check = 1;
        if (edUser.getText().length() == 0 || edhoten.getText().length() == 0 ||
                edPass.getText().length() == 0 || edEnPass.getText().length() == 0) {
            Toast.makeText(getContext(), "B???n ph???i nh???p ?????y ????? th??ng tin", Toast.LENGTH_SHORT).show();
            check = -1;
        } else {
            String pass = edPass.getText().toString();
            String rePass = edEnPass.getText().toString();
            if (!pass.equals(rePass)) {
                Toast.makeText(getContext(), "M???t kh???u kh??ng tr??ng kh???p", Toast.LENGTH_SHORT).show();
                check = -1;
            }
        }
        return check;
    }

}
