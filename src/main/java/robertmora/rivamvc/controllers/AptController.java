package robertmora.rivamvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import robertmora.rivamvc.models.Apartment;
import robertmora.rivamvc.models.Category;
import robertmora.rivamvc.models.data.ApartmentDao;
import robertmora.rivamvc.models.data.CategeoryDao;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("apartment")
public class AptController {

    @Autowired
    ApartmentDao aptDao;

    @Autowired
    CategeoryDao categeoryDao;

    // Request path: /apartment
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("apartments", aptDao.findAll());
        model.addAttribute("title", "My Apartments");
        return "apartment/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddApartmentForm(Model model) {
        model.addAttribute("title", "Add apartment");
        model.addAttribute(new Apartment());
        model.addAttribute("categories", categeoryDao.findAll());
        return "apartment/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddAparmentForm(@ModelAttribute @Valid Apartment newApt,
                                         Errors errors, @RequestParam(required = false) Integer categoryId,
                                         Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Apartment");
            model.addAttribute("categories", categeoryDao.findAll());
            return "apartment/add";
        }

        if (categoryId != null) {
            Optional<Category> result = categeoryDao.findById(categoryId);
            if (result.isPresent()) {
                Category cat = result.get();
                newApt.setCategory(cat);
            }
        }

        aptDao.save(newApt);

        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveApartmentForm(Model model) {
        model.addAttribute("apartments", aptDao.findAll());
        model.addAttribute("title", "Remove Apartment");
        return "apartment/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveApartmentForm(@RequestParam int[] aptIds) {
//        for (Apartment apt : apts) {
//            AptData.remove(apt.getId());
//        }
        for (int id : aptIds) {
            //AptData.remove(id);
            //aptDao.delete(id);
        }

        return "redirect:";
    }

    public String category(Model model, @RequestParam int id) {

        Optional<Category> result = categeoryDao.findById(id);
        if (result.isPresent()) {
            Category cat = result.get();
            List<Apartment> aparts = cat.getApartments();
            model.addAttribute("apartments", aparts);
            model.addAttribute("title", "Apartments in" +
                    " this category: " + cat.getName());
        }
        return "apartment/index";
    }

}










