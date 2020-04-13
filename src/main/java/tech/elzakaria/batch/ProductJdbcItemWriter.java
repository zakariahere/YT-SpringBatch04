package tech.elzakaria.batch;

import lombok.Getter;
import lombok.Setter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import tech.elzakaria.beans.Individu;

import java.util.List;


@Getter
@Setter
public class ProductJdbcItemWriter implements ItemWriter<Individu> {


    static int counter = 0;

    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(List<? extends Individu> items) throws Exception {

        counter++;
        items.forEach(item -> {
            jdbcTemplate.update("INSERT INTO INDIVIDUS(IDF,NOM,PRENOM,DATE_NAISSANCE) VALUES(?,?,?,?)", item.getIdFonctionnel(), item.getNom(), item.getPrenom(), item.getDate());
        });
    }
}
