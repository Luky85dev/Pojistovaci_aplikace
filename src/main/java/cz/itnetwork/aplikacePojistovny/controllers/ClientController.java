package cz.itnetwork.aplikacePojistovny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.ui.Model;
import cz.itnetwork.aplikacePojistovny.models.exceptions.ClientNotFoundException;
import cz.itnetwork.aplikacePojistovny.models.dto.mappers.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.access.annotation.Secured;
import cz.itnetwork.aplikacePojistovny.models.dto.ClientDTO;
import cz.itnetwork.aplikacePojistovny.models.services.ClientService;

@Controller
@RequestMapping("/clientes")
public class ClientController {

    //@Secured("ROLE_ADMIN")                                    //vykreslí formulář pro přidání pojištěnce
    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute
                                       ClientDTO client) {
        return "pages/clientes/create";
    }
    @Autowired
    private ClientService clientService;

    //@Secured("ROLE_ADMIN")
    @PostMapping("create")
    public String createClient(
            @Valid @ModelAttribute ClientDTO client,             //zde přijdou data z formuláře
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderCreateForm(client);

        clientService.create(client);                               //přidání pojištěného do databáze
        redirectAttributes.addFlashAttribute("success", "Nový klient uložen.");

        return "redirect:/clientes";
    }

    @GetMapping
    public String renderIndex(Model model) {                             //předávání pojištěného šabloně
        List<ClientDTO> client = clientService.getAll();
        model.addAttribute("clientes", client);

        return "/pages/clientes/index";
    }
    @GetMapping("{clientId}")
    public String renderDetail(
            @PathVariable long clientId,
            Model model
    ) {
        ClientDTO client = clientService.getById(clientId);
        model.addAttribute("clientes", client);

        return "pages/clientes/detail";
    }

    @Autowired
    private ClientMapper clientMapper;

    //@Secured("ROLE_ADMIN")
    @GetMapping("edit/{clientId}")                     //vykresleni editačního formuláře [GET]
    public String renderEditForm(                   // získání článku dle id a překopírování přepravce
            @PathVariable Long clientId,
            ClientDTO client
    ) {
        ClientDTO fetchedClient = clientService.getById(clientId);
        clientMapper.updateClientDTO(fetchedClient, client);

        return "pages/clientes/edit";
    }
    //@Secured("ROLE_ADMIN")
    @PostMapping("edit/{clientId}")                // odeslání formuláře [POST]
    public String editClient(                  //kontrola formuláře,nastavujeme id,voláme edit()
            @PathVariable long clientId,
            @Valid ClientDTO client,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors())
            return renderEditForm(clientId, client);

        client.setClientId(clientId);
        clientService.edit(client);
        redirectAttributes.addFlashAttribute("success", "Údaje klienta upraveny.");

        return "redirect:/clientes";
    }

    //@Secured("ROLE_ADMIN")
    @GetMapping("delete/{clientId}")                               //NAHRADIT POSTEM !!!!!!
    public String deleteClient(
            @PathVariable long clientId,
            RedirectAttributes redirectAttributes
    ) {
        clientService.remove(clientId);
        redirectAttributes.addFlashAttribute("success", "Klient vymazán.");

        return "redirect:/clientes";
    }

    @ExceptionHandler({ClientNotFoundException.class})
    public String handleClientNotFoundException(
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("error", "Klient nenalezen.");
        return "redirect:/clientes";
    }

}
