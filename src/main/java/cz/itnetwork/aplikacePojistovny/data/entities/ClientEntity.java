package cz.itnetwork.aplikacePojistovny.data.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "klienti")
public class ClientEntity {
//reprezentuje tabulku v MySQL
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long clientId;

        @OneToMany(mappedBy = "client")
        private List<InsuredEntity> clientInsureds;

        @Column(nullable = false)
        private String jmeno;

        @Column(nullable = false)
        private String prijmeni;

        @Column(nullable = false, columnDefinition = "TEXT")
        private String email;

        @Column(nullable = false)
        private long telefon;

        @Column(nullable = false)
        private String ulice;

        @Column(nullable = false)
        private String mesto;

        @Column (nullable = false)
        private long psc;

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


