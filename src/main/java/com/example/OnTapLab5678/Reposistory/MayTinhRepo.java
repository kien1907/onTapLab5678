package com.example.OnTapLab5678.Reposistory;

import com.example.OnTapLab5678.Entity.MayTInh;
import com.example.OnTapLab5678.Util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MayTinhRepo {
    public int add(MayTInh mayTInh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(mayTInh);
            transaction.commit();
            return 0;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 1;
        }
    }

    public int update(MayTInh mayTInh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(mayTInh);
            transaction.commit();
            return 0;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 1;
        }
    }

    public int delete(MayTInh mayTInh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.remove(mayTInh);
            transaction.commit();
            return 0;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return 1;
        }
    }

    public List<MayTInh> getAll() {
        List<MayTInh> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM MayTInh ");
            list = query.getResultList();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }
    }

    public MayTInh findById(String id) {
        MayTInh mayTInh = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            mayTInh = session.get(MayTInh.class,id);
            return mayTInh;
        }catch (Exception e){
            e.printStackTrace();
            return mayTInh;
        }
    }
}
