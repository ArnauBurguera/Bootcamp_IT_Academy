package cat.itacademy.barcelonactiva.BurgueraCalles.Arnau.s04.t02.n03.S04T02N03BurgueraCallesArnau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })//He hagut de canviar això pq sinó no funcionava
public class S04T02N03BurgueraCallesArnauApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03BurgueraCallesArnauApplication.class, args);
	}

}
