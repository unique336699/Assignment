package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springrest.springrest.allData.Data;
import com.springrest.springrest.entities.Loadlists;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
@ResponseBody
public class LoadController {

    @Autowired
    private Data data;

    @GetMapping("/load")
    public List<Loadlists> getAllLoadLists() {
        return this.data.getAllLists();
    }

    @GetMapping("/load/{shipperId}")
    public Loadlists getList(@PathVariable String shipperId) {
        return data.getAllListById(shipperId);
    }

    @PostMapping("/load")
    public String addList(@RequestBody Loadlists list)
    {
        this.data.addList(list);
        return "loads details added successfully";
    }

    @DeleteMapping("/load/{shipperId}")
    public Loadlists deleteList(@PathVariable String shipperId){
        return this.data.deleteList(shipperId);
    }

    @PutMapping("/load/{shipperId}")
    public Loadlists updateList(@PathVariable String shipperId, @RequestBody Loadlists list) {
        
        this.data.updateList(shipperId,list);
        return list;
    }
}
