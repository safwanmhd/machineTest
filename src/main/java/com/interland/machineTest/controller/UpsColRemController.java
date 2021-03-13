package com.interland.machineTest.controller;

import com.interland.machineTest.domain.UpsColRem;
import com.interland.machineTest.service.UpsColRemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class UpsColRemController {

    @Autowired
    private UpsColRemService upsColRemService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {

        List<UpsColRem> list = upsColRemService.listAll();
        model.addAttribute("listUps", list);
        return "index";
    }

    @RequestMapping("/new")
    public String addNewData(Model model) {
        UpsColRem upsColRem = new UpsColRem();
        model.addAttribute("upsRem", upsColRem);
        return "addnew";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveData(@ModelAttribute("upsRem") UpsColRem upsColRem) throws IOException {
        //upsColRem.setProfilePic(multipartFile.getBytes());
        upsColRemService.save(upsColRem);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable(name = "id") Long id) {

        ModelAndView modelAndView = new ModelAndView("edit_data");
        UpsColRem upsColRem = upsColRemService.get(id);
        modelAndView.addObject("upsRem", upsColRem);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        upsColRemService.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/view/{id}")
    public ModelAndView view(@PathVariable(name = "id") Long id) {

        ModelAndView modelAndView = new ModelAndView("view");
        UpsColRem upsColRem = upsColRemService.get(id);
        modelAndView.addObject("upsRem", upsColRem);
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("clientId") String clientId,
                              @RequestParam("schemeId") String schemeId,
                              Model model) {

        List<UpsColRem> list = upsColRemService.findByClientOrScheme(clientId, schemeId);
        model.addAttribute("listUps", list);
        return "index";
    }
}
