package ducktph19569.fpoly.ducktph19569_mob2041_libmanager.QuanlyvsThongke;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPDAO.PhieuMuonDao;
import ducktph19569.fpoly.ducktph19569_mob2041_libmanager.LOPPRODUCT.PhieuMuon;

public class PhieuMuonViewModel extends AndroidViewModel {
    MutableLiveData<List<PhieuMuon>> liveData;
    PhieuMuonDao dao;

    public PhieuMuonViewModel(@NonNull @NotNull Application application) {
        super(application);
        liveData = new MutableLiveData<>();
        dao = new PhieuMuonDao(application);
    }

    public MutableLiveData<List<PhieuMuon>> getLiveData() {
        loadData();
        return liveData;
    }

    public void loadData() {
        List<PhieuMuon> list = new ArrayList<>();
        list=dao.GETPM();
        liveData.setValue(list);
    }
}
