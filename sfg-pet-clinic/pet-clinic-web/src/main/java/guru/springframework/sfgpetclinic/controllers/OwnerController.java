package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.Model.Owner;
import guru.springframework.sfgpetclinic.Services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


//    @RequestMapping({"","/", "/index", "/index.html"})
//    public String listOfOwners(Model model){
//        model.addAttribute("owners",ownerService.findAll());
//        return "owners/index";
//    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId){
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(this.ownerService.findByID(ownerId));
        return mav;
    }

    @RequestMapping("/find")
    public String findOwners(Model model){
        model.addAttribute(Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
        if(owner.getLastName() == null){
            owner.setFirstName("");
        }
        List<Owner> results = this.ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");
        if(results.isEmpty()){
            result.rejectValue("lastName","NotFound","NotFound");
            return "owners/findOwners";
        } else if(results.size() == 1){
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else{
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }

    }

    @GetMapping("/new")
    public String initCreationForm(Model model){
        model.addAttribute("owner", Owner.builder().build());
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Validated Owner owner, BindingResult result){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        } else {
            ownerService.save(owner);
            return "redirect:/owners/"+owner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") Long ownerId, Model model){
        Owner owner = ownerService.findByID(ownerId);
        model.addAttribute(owner);
        return "owners/createOrUpdateOwnerForm";

    }
    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Validated Owner owner, BindingResult result, @PathVariable("ownerId") Long ownerId){
        if(result.hasErrors()){
            return "owners/createOrUpdateOwnerForm";
        } else{
            owner.setId(ownerId);
            return "redirect:/owners/"+owner.getId();
        }

    }
    @InitBinder
    public void NotAllotFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }
}
