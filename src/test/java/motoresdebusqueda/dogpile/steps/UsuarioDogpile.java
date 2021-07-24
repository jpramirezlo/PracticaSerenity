package motoresdebusqueda.dogpile.steps;

import motoresdebusqueda.dogpile.pageobject.DogpilePaginaPrincipal;
import motoresdebusqueda.dogpile.pageobject.DogplilePaginaResultado;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsuarioDogpile {
  String actor;

  DogpilePaginaPrincipal paginaPrincipal;
  DogplilePaginaResultado paginaResulado;

  @Step("#actor ingresa a la pagina principal de dogpile")
  public void ingresa_a_dogpile() {
    paginaPrincipal.open();
  }

  @Step("#actor realiza una búsqueda de: {0}")
  public void busca_por_palabra_clave(String palabraClave) {
    paginaPrincipal.ingresarPalabraClave(palabraClave);
    paginaPrincipal.realizarBusqueda();
  }

  @Step("#actor deberia poder ver resultados que contengan la palabra {0}")
  public void deberia_ver_resulatados_con_palabra(String palabraEsperada) {
    List<String> resultados = paginaResulado.obtenerResultados();
    resultados.replaceAll(String::toLowerCase);
    for (int i = 0; i < resultados.size(); i++) {
      System.out.println(resultados.get(i));
    }

    assertThat(resultados, Matchers.everyItem(Matchers.containsString(palabraEsperada)));
  }

  @Step("#actor deberia ver el texto esperado: {1} en el resultado del título: {0}")
  public void deberia_ver_resultado_de_titulo_con_texto_correcto(String tituloDeResultado, String textoDeResultadoEsperado) {
    String texto = paginaResulado.obtenerTextoDeTituloResultado(tituloDeResultado);
    System.out.println("texto = " + texto);
    System.out.println(textoDeResultadoEsperado);
    assertThat(texto, containsString(textoDeResultadoEsperado));
  }
}
