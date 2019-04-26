package robertmora.rivamvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import robertmora.rivamvc.models.Category;
import robertmora.rivamvc.models.data.CategeoryDao;

@Controller
// todo @RequestMapping()
public class CategController {
    @Autowired
    CategeoryDao catDao;

    // Request path: /apartment
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("categories", catDao.findAll());
        model.addAttribute("title", "My Categories");
        return "category/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCategorytForm(Model model) {
        model.addAttribute("title", "Add category");
        model.addAttribute(new Category());
        model.addAttribute("categories", catDao.findAll());
        return "categories/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCategoryForm(@ModelAttribute Category newCateg,
                                         Model model) {
        model.addAttribute("title", "Add category");

        catDao.save(newCateg);

        return "redirect:";
    }
}
