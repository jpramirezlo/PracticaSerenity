package motoresdebusqueda.dogpile.pageobject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.dogpile.com/")
public class DogpilePaginaPrincipal extends PageObject {

    @FindBy(css = "input[id='q']")
    WebElementFacade cajaBusqueda;

    @FindBy(css = "button[type='submit']")
    WebElementFacade botonBuscar;

    public void ingresarPalabraClave(String palabraClave) {
        cajaBusqueda.type(palabraClave);
    }

    public void realizarBusqueda() {
        botonBuscar.click();
    }
}
