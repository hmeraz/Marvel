package mx.com.Marvel.web.rest;

import mx.com.Marvel.commons.to.ColaboratorTO;
import mx.com.Marvel.web.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class MarvelControllerTest extends BaseTest {

    @Test
    public void exampleTest() {
        ColaboratorTO colaborators = this.colaboratorsFacade.getColaboratorsByHero("ironman");

         Assert.assertNotNull(colaborators);
         Assert.assertEquals(2, colaborators.getEditors().size());
    }
}
