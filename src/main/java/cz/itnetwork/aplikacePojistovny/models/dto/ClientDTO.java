package cz.itnetwork.aplikacePojistovny.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class ClientDTO {

        private long clientId;

        @NotBlank(message = "Vyplňte prosím jméno")
        @NotNull(message = "Vyplňte prosím jméno")
        @Size(max = 100, message = "Jméno je příliš dlouhé")
        private String jmeno;

        @NotBlank(message = "Vyplňte přijmení")
        @NotNull(message = "Vyplňte přijmení")
        @Size(max = 100, message = "Přijmení je příliš dlouhé")
        private String prijmeni;

        @NotBlank(message = "Zadejte email")
        @NotNull(message = "Zadejte email")
        @Size(max = 100, message = "Email je příliš dlouhý")
        private String email;


        @NotNull(message = "Vyplňte telefonní číslo")

        private long telefon;

        @NotBlank(message = "Vyplňte ulici a číslo popisné bydliště")
        @NotNull(message = "Vyplňte ulici a číslo popisné bydliště")
        @Size(max = 100, message = "Adresa je příliš dlouhá")
        private String ulice;

        @NotBlank(message = "Vyplňte město bydliště")
        @NotNull(message = "Vyplňte město bydliště")
        @Size(max = 30, message = "Město je příliš dlouhé")
        private String mesto;


        @NotNull(message = "Vyplňte PSČ bydliště")

        private long psc;

        //region: Getters and setters
        public long getClientId() {
            return clientId;
        }

        public void setClientId(long clientId) {
            this.clientId = clientId;
        }


        public String getJmeno() {
            return jmeno;
        }

        public void setJmeno(String jmeno) {
            this.jmeno = jmeno;
        }


        public String getPrijmeni() {
        return prijmeni;
    }

        public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }



        public String getEmail() {
            return email;
        }


        public void setEmail(String email) {
            this.email = email;
        }


        public long getTelefon() {
        return telefon;
    }

        public void setTelefon(long telefon) {
        this.telefon = telefon;
    }


        public String getUlice() {
        return ulice;
    }

        public void setUlice(String ulice) {
        this.ulice = ulice;
    }


        public String getMesto() {
        return mesto;
    }

        public void setMesto(String mesto) {
        this.mesto = mesto;
    }


        public long getPsc() {
        return psc;
    }

        public void setPsc(long psc) {
        this.psc = psc;
    }

    }


