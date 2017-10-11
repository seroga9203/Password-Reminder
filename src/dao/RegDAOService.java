package dao;

import entity.Record;
import java.util.List;

public class RegDAOService {
    public static void add(Record r){
        RegDAO.add(r);
    }
    public static List<Record> get(){
        return RegDAO.get();
    }
}
