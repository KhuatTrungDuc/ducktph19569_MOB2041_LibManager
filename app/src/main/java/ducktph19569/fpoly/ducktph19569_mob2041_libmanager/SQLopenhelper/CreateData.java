package ducktph19569.fpoly.ducktph19569_mob2041_libmanager.SQLopenhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPPRODUCT.NhanVien;

public class CreateData extends SQLiteOpenHelper {
    private static final String DB_NAME = "PNLINB.db";
    private static final int VERSION = 2;

    public CreateData(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Bảng Nhân Viên
        String tb_nv =
                "create table NhanVien (" +
                        "maNV TEXT PRIMARY KEY UNIQUE, " +
                        "hoTen TEXT NOT NULL, " +
                        "matKhau TEXT NOT NULL)";

        db.execSQL(tb_nv);
        //Bảng Thành viên
        String tb_tv =
                "create table ThanhVien (" +
                        "maTV INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "hoTen TEXT NOT NULL, " +
                        "namSinh TEXT NOT NULL)";
        db.execSQL(tb_tv);
        //Bảng Loại sách
        String tb_ls =
                "create table LoaiSach (" +
                        "maLoai INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nhacc TEXT NOT NULL, " +
                        "tenLoai TEXT UNIQUE NOT NULL)";
        db.execSQL(tb_ls);
        //Bảng Sách
        String tb_S =
                "create table Sach (" +
                        "maSach INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "tenSach TEXT NOT NULL, " +
                        "giaThue INTEGER NOT NULL, " +
                        "tacgia TEXT NOT NULL, " +
                        "maLoai INTEGER REFERENCES LoaiSach(maLoai))";

        db.execSQL(tb_S);
        db.execSQL("alter table Sach add soluong_ducktph19569 interger");
        //Bảng Phiếu Mượn
        String tb_pm =
                "create table PhieuMuon (" +
                        "maPM INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "maNV TEXT REFERENCES NhanVien(maNV), " +
                        "maTV INTEGER REFERENCES ThanhVien(maTV), " +
                        "maSach INTEGER REFERENCES Sach(maSach), " +
                        "tienThue INTEGER NOT NULL, " +
                        "ngay DATE NOT NULL, " +
                        "traSach INTEGER NOT NULL)";
        db.execSQL(tb_pm);
        db.execSQL("alter table PhieuMuon add giomuon_ph19569 interger");
        db.execSQL("insert into PhieuMuon values(13,'Nguyen G',13,13,2500,'2022/11/18',1,6)");
//        db.execSQL("alter table phieumuon add gio_muon_ph19466 interger");
//
//        db.execSQL("insert into loaisach values (1,'quân')");
//        db.execSQL("insert into loaisach values (2,'quân1')");
//
//        db.execSQL("insert into sach values (1,'quân1',2500,1,100)");
//        db.execSQL("insert into sach values (2,'quân2',2500,2,100)");
//
//        db.execSQL("insert into thanhvien values (1,'QuânTran','2002')");
//        db.execSQL("insert into phieumuon values (1,1,1,2500,'20/10/2002',1,23)");
//        db.execSQL("insert into phieumuon values (2,1,2,2500,'20/9/2002',1,4)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa khi update phiên bản
        String dropTableThuThu = "drop table if exists NhanVien";
        db.execSQL(dropTableThuThu);
        String dropTableThanhVien = "drop table if exists ThanhVien";
        db.execSQL(dropTableThanhVien);
        String dropTableLoaiSach = "drop table if exists LoaiSach";
        db.execSQL(dropTableLoaiSach);
        String dropTableSach = "drop table if exists Sach";
        db.execSQL(dropTableSach);
        String dropTablePhieuMuon = "drop table if exists PhieuMuon";
        db.execSQL(dropTablePhieuMuon);

        onCreate(db);
    }
}
