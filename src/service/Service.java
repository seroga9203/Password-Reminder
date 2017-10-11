package service;

import dao.RegDAOService;
import entity.Record;
import java.util.List;

public class Service {
    public static String getStringRepresentationOfRecords(){
        List<Record> recs = RegDAOService.get();
        StringBuilder out = new StringBuilder(Integer.valueOf(200));
        for(Record r:recs){
            out.append(r.toString()+"\n");
        }
        return out.toString();
    }

    public static void sendDataToDB(String url, String login, String pass) {
        RegDAOService.add(new Record(url, login, pass));
    }
}
