package robertmora.rivamvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("apartment")
public class AptController {

    static ArrayList<String> apartments = new ArrayList<>();

    // Request path: /apartment
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("apartments", apartments);
        model.addAttribute("title", "My Apartments");
        return "apartment/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddApartmentForm(Model model) {
        model.addAttribute("title", "Add apartment");
        return "apartment/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAparmentForm(@RequestParam String aptName) {
    //public String processsAddApartmentForm(HttpServletRequest request) {
    //    String aptName = request.getParameter("aptName");
        apartments.add(aptName);

        // Redirect to Apartments azaz index
        return "redirect:";
    }

}










