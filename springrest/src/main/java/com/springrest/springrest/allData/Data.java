package com.springrest.springrest.allData;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springrest.springrest.entities.Loadlists;

@Component
public class Data {
    private static List<Loadlists> dataList = new ArrayList<>(); 

    static {
        dataList.add(new Loadlists("mumbai","jaipur","chemicals","canter",1,100,"optional","1712","23/07/23"));
        dataList.add(new Loadlists("kolkata","jaipur","chemicals","canter",1,100,"optional","1713","21/07/23"));
        dataList.add(new Loadlists("hariyana","jaipur","chemicals","canter",1,100,"optional","1714","20/07/24"));
    }

    public List<Loadlists> getAllLists() {
        return dataList;
    }

    public Loadlists getAllListById(String id) {
        Loadlists result = null;

        result = dataList.stream().filter(e -> e.getShipperId().equals(id)).findFirst().orElse(null);
        return result;
    }

    public Loadlists addList(Loadlists list){
        dataList.add(list);
        return list;
    }

    public Loadlists deleteList(String lid){
        Loadlists result = null;

        result = dataList.stream().filter(e -> e.getShipperId().equals(lid)).findFirst().orElse(null);
        dataList.remove(result);
        return result;
    }

    public Loadlists updateList(String shipperId, Loadlists list){
        Loadlists result = null;

        result = dataList.stream().filter(e -> e.getShipperId().equals(shipperId)).findFirst().orElse(null);
        dataList.remove(result);
        dataList.add(list);
        return list;

        // list.stream().map(e -> {
        //     if(e.getShipperId() == shipperId){
        //         e.setTruckType(list.getTruckType());
        //     }
        //     return e;
        // }).collect(Collectors.toList());
    }
}
