package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Catalog;
import ra.model.service.ICatalogService;

import java.util.List;

@Controller
@RequestMapping("catalogController")
public class CatalogController {
    @Autowired
    private ICatalogService catalogService;

    @GetMapping("getAll")
    public ModelAndView getAllCatalog(Model model){
        ModelAndView mav = new ModelAndView("category");
        List<Catalog> listCatalog = catalogService.getListPagingCatalog(1);
        mav.addObject("listCatalog",listCatalog);
        Catalog catNew = new Catalog();
        model.addAttribute("catNew",catNew);
        int endPage = catalogService.getEndPage();
        model.addAttribute("endPage",endPage);
        return mav;
    }

    @GetMapping("getListCatalogForCreate")
    public ModelAndView getCatalogForCreate(){
        ModelAndView mav = new ModelAndView("newCatalog");
        List<Catalog> listCatalogForCreate = catalogService.getCatalogForCreate();
        mav.addObject("listCatalogForCreate",listCatalogForCreate);
        return mav;
    }

    @GetMapping("initCreate")
    public String initCreate(Model model){
        List<Catalog> listCatalogForCreate = catalogService.findAll();
        model.addAttribute("listCatalogForCreate",listCatalogForCreate);
        Catalog catNew = new Catalog();
        model.addAttribute("catNew",catNew);
        return "newCatalog";
    }

    @PostMapping("create")
    public String createCatalog(Catalog catNew){
        boolean result = catalogService.insert(catNew);
        if (result){
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping("initUpdate")
    public String initUpdate(Model model, int catalogID){
        List<Catalog> listCatalogForCreate = catalogService.findAll();
        model.addAttribute("listCatalogForCreate",listCatalogForCreate);
        Catalog catUpdate = (Catalog) catalogService.getByID(catalogID);
        model.addAttribute("catUpdate",catUpdate);
        return "updateCatalog";
    }


    @PostMapping("update")
    public String update(Catalog cat){
        boolean result = catalogService.update(cat);
        if (result){
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping("delete")
    public String delete(int catalogID){
        boolean result = catalogService.delete(catalogID);
        if (result){
            return "redirect:getAll";
        } else {
            return "error";
        }
    }

    @GetMapping("search")
    public ModelAndView searchByName(Model model, String searchName){
        ModelAndView mav = new ModelAndView("category");
        List<Catalog> listSearchCatalog = catalogService.getCatalogForSearchPages(searchName,1);
        model.addAttribute("listCatalog",listSearchCatalog);
        Catalog catNew = new Catalog();
        model.addAttribute("catNew",catNew);
        int endPage = catalogService.getEndPageForSearch(searchName);
        model.addAttribute("endPage",endPage);
        return mav;
    }

    @GetMapping("displayPages")
    public ModelAndView displayPages(Model model, int index){
        ModelAndView mav = new ModelAndView("category");
        List<Catalog> listCatalogForPage = catalogService.getListPagingCatalog(index);
        model.addAttribute("listCatalog", listCatalogForPage);
        Catalog catNew = new Catalog();
        model.addAttribute("catNew",catNew);
        int endPage = catalogService.getEndPage();
        model.addAttribute("endPage",endPage);
        return mav;
    }
}
