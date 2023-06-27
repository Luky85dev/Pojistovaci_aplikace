package cz.itnetwork.aplikacePojistovny.models.dto;

import cz.itnetwork.aplikacePojistovny.data.entities.ClientEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InsuredDTO {

    private long insuredId;
    private ClientEntity clientId;

    @NotBlank(message = "Vyberte prosím druh pojištění")
    @NotNull(message = "Vyberte prosím druh pojištění")

    private String pojisteni;


    @NotNull(message = "Vyplňte prosím částku")

    private long castka;

    @NotBlank(message = "Vyplňte prosím co je předmětem pojištění")
    @NotNull(message = "Vyplňte prosím co je předmětem pojištění")
    @Size(max = 100, message = "Text udaného předmětu je příliš dlouhý")
    private String predmet;


    @NotBlank(message = "Vyplňte prosím začátek platnosti pojištění")
    @NotNull(message = "Vyplňte prosím začátek platnosti pojištění")
    @Size(max = 100, message = "Text platnosti je příliš dlouhý")
    private String platnostOd;

    @NotBlank(message = "Vyplňte prosím konec platnosti pojištění")
    @NotNull(message = "Vyplňte prosím konec platnosti pojištění")
    @Size(max = 100, message = "Text platnosti je příliš dlouhá")
    private String platnostDo;


    //region: Getters and setters
    public ClientEntity getClientId() {
       return clientId;
    }

    public void setClientId(ClientEntity clientId) {
        this.clientId = clientId;
    }


    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }


    public String getPojisteni() {
        return pojisteni;
    }

    public void setPojisteni(String pojisteni) {
        this.pojisteni = pojisteni;
    }


    public long getCastka() {
        return castka;
    }

    public void setCastka(long castka) {
        this.castka = castka;
    }



    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }


    public String getPlatnostOd() {
        return platnostOd;
    }

    public void setPlatnostOd(String platnostOd) {
        this.platnostOd = platnostOd;
    }


    public String getPlatnostDo() {
        return platnostDo;
    }

    public void setPlatnostDo(String platnostDo) {
        this.platnostDo = platnostDo;
    }




}




