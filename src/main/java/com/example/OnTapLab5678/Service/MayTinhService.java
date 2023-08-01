package com.example.OnTapLab5678.Service;

import com.example.OnTapLab5678.Entity.MayTInh;
import com.example.OnTapLab5678.Reposistory.MayTinhRepo;
import com.example.OnTapLab5678.Util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MayTinhService {

    MayTinhRepo mayTinhRepo = new MayTinhRepo();

    public int add(MayTInh mayTInh) {
        int result = this.mayTinhRepo.add(mayTInh);
        return result;
    }

    public int update(MayTInh mayTInh) {
        int result = this.mayTinhRepo.update(mayTInh);
        return result;
    }

    public int delete(MayTInh mayTInh) {
        int result = this.mayTinhRepo.delete(mayTInh);
        return result;
    }

    public List<MayTInh> getAll() {
        return this.mayTinhRepo.getAll();
    }

    public MayTInh findById(String id) {
        return this.mayTinhRepo.findById(id);
    }
}
