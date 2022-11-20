package ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPDAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPPRODUCT.Sach;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPPRODUCT.Top;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.SQLopenhelper.CreateData;

public class Top10Dao {
    CreateData createData;
    SQLiteDatabase liteDatabase;
    Context context;

    public Top10Dao(Context context) {
        this.context = context;
        createData = new CreateData(context);
        liteDatabase = createData.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Top> GetTop() {
        // gới hạn 10 kết quả từ trên xuống
        String sql = "SELECT maSach , COUNT(maSach) AS soLuong FROM PhieuMuon GROUP BY maSach ORDER BY soLuong DESC LIMIT 10";
        List<Top> list = new ArrayList<>();
        SachDao sachDao = new SachDao(context);
        Cursor cursor = liteDatabase.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Top top = new Top();
            Sach sach = sachDao.getId(cursor.getString(cursor.getColumnIndex("maSach")));
            top.tensach= sach.getTens();
            top.soluong=(Integer.parseInt(cursor.getString(cursor.getColumnIndex("soLuong"))));
            list.add(top);
        }
        return list;
    }
//
//    public int GETTOP() {
//        String sql = "SELECT maSach , COUNT(maSach) AS soLuong FROM PhieuMuon GROUP BY maSach ORDER BY soLuong DESC LIMIT 10";
//        Cursor cursor = liteDatabase.rawQuery(sql, null);
//        cursor.moveToFirst();
//        return cursor.getInt(0);
//    }
}
