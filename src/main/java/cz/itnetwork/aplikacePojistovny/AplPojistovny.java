package cz.itnetwork.aplikacePojistovny;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AplPojistovny {

        public static void main(String[] args) {

            SpringApplication.run(AplPojistovny.class, args);
        }

    }
