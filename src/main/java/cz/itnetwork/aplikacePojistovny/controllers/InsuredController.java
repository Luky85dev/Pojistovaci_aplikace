package cz.itnetwork.aplikacePojistovny.controllers;

import cz.itnetwork.aplikacePojistovny.models.dto.InsuredDTO;
import cz.itnetwork.aplikacePojistovny.models.dto.mappers.InsuredMapper;
import cz.itnetwork.aplikacePojistovny.models.exceptions.InsuredNotFoundException;
import cz.itnetwork.aplikacePojistovny.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/insureds")
public class InsuredController {

    //@Secured("ROLE_ADMIN")                                    //vykreslí formulář pro přidání pojištění
    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute
                                   InsuredDTO insured) {
        return "pages/insureds/create";
    }
    @Autowired
    private InsuredService insuredService;

    //@Secured("ROLE_ADMIN")
    @PostMapping("create")
    public String createInsured(
            @Valid @ModelAttribute InsuredDTO insured,             //zde přijdou data z formuláře
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderCreateForm(insured);

        insuredService.create(insured);                               //přidání pojištěného do databáze
        redirectAttributes.addFlashAttribute("success", "Nové pojištění uloženo.");

        return "redirect:/insureds";
    }

    @GetMapping
    public String renderIndex(Model model) {                             //předávání pojištěného šabloně
        List<InsuredDTO> insured = insuredService.getAll();
        model.addAttribute("insureds", insured);

        return "/pages/insureds/index";
    }
    @GetMapping("{insuredId}")
    public String renderDetail(
            @PathVariable long insuredId,
            Model model
    ) {
        InsuredDTO insured = insuredService.getById(insuredId);
        model.addAttribute("insureds", insured);

        return "pages/insureds/detail";
    }

    @Autowired
    private InsuredMapper insuredMapper;

    //@Secured("ROLE_ADMIN")
    @GetMapping("edit/{insuredId}")                     //vykresleni editačního formuláře [GET]
    public String renderEditForm(                   // získání článku dle id a překopírování přepravce
    @PathVariable Long insuredId,
    InsuredDTO insured
                                                     
    ) {
        InsuredDTO fetchedInsured = insuredService.getById(insuredId);
        insuredMapper.updateInsuredDTO(fetchedInsured, insured);

        return "pages/insureds/edit";
    }
    //@Secured("ROLE_ADMIN")
    @PostMapping("edit/{insuredId}")                // odeslání formuláře [POST]
    public String editInsured(
            @PathVariable long insuredId,                   //kontrola formuláře,nastavujeme id,voláme edit()
            @Valid InsuredDTO insured,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderEditForm(insuredId, insured);

        insured.setInsuredId(insuredId);
        insuredService.edit(insured);
        redirectAttributes.addFlashAttribute("success", "Pojištění bylo upraveno.");

        return "redirect:/insureds";
    }

    //@Secured("ROLE_ADMIN")
    @GetMapping("delete/{insuredId}")                               //NAHRADIT POSTEM !!!!!!
    public String deleteInsured(
            @PathVariable long insuredId,
            RedirectAttributes redirectAttributes
    ) {
        insuredService.remove(insuredId);
        redirectAttributes.addFlashAttribute("success", "Pojištění bylo zrušeno.");

        return "redirect:/insureds";
    }

    @ExceptionHandler({InsuredNotFoundException.class})
    public String handleInsuredNotFoundException(
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("error", "Pojištění nenalezeno.");
        return "redirect:/insureds";
    }

}


