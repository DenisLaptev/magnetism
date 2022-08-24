package com.weblab.magnetism.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public abstract class CRUDController<E, K> {

    abstract String getEntityName();

    @GetMapping("/list")
    public String showList() {

        return getEntityName() + "/list";
    }


    @GetMapping("/read/{id}")
    public String showRead(@PathVariable String id, Model model) {

        model.addAttribute("id", id);
        return getEntityName() + "/read";
    }

    @GetMapping("/create")
    public String showCreate() {

        return getEntityName() + "/create";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable String id, Model model) {

        model.addAttribute("id", id);
        return getEntityName() + "/update";
    }
}
