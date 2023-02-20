package cat.itacademy.barcelonactiva.Calabres.Pau.s04.t02.n03.S04T02N03CalabresPau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//aquesta anotació ha sigut necesaria per poder garantir la autoconfiguració, d'altre manera
// donava error (s'havia d'excloure la autoconfiguració de la fons de les dades)
//resposta trobada a: https://stackoverflow.com/questions/51221777/failed-to-configure-a-datasource-url-attribute-is-not-specified-and-no-embedd
public class S04T02N03CalabresPauApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03CalabresPauApplication.class, args);
	}

}
