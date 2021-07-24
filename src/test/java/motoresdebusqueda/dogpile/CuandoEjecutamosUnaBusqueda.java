package motoresdebusqueda.dogpile;

import motoresdebusqueda.dogpile.steps.UsuarioDogpile;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CuandoEjecutamosUnaBusqueda {

    @Steps
    UsuarioDogpile juan;

    @Managed
    WebDriver driver;

    @Test
    public void deberiamos_ver_resultados_relevantes(){
        juan.ingresa_a_dogpile();
        juan.busca_por_palabra_clave("rock nacional");
        juan.deberia_ver_resulatados_con_palabra("rock");
    }


}
