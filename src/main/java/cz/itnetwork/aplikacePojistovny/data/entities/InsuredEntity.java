package cz.itnetwork.aplikacePojistovny.data.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "pojisteni")
public class InsuredEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuredId;

    @ManyToOne
    private ClientEntity client;


    @Column(nullable = false)
    private String pojisteni;

    @Column(nullable = false)
    private long castka;

    @Column(nullable = false)
    private String predmet;

    @Column(nullable = false)
    private String platnostOd;

    @Column(nullable = false)
    private String platnostDo;


    public long getInsuredId() {
        return insuredId;
    }
    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }


    public ClientEntity getClientId() {
        return client;
    }

    public void setClientId(ClientEntity clientId) {
      this.client = clientId;
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

