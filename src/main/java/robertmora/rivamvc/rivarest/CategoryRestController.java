package robertmora.rivamvc.rivarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import robertmora.rivamvc.models.Category;
import robertmora.rivamvc.models.data.CategeoryDao;

@RestController
public class CategoryRestController {

    //TODO: mooooooove injected DAO to a service class!
    @Autowired
    private CategeoryDao catDao;

    @RequestMapping(value="/categories", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        catDao.saveAndFlush(category);
        return category;
    }

}
