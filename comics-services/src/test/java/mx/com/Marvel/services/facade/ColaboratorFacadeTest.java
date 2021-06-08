package mx.com.Marvel.services.facade;

import mx.com.Marvel.commons.to.ColaboratorTO;
import mx.com.Marvel.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ColaboratorFacadeTest extends BaseTest {

    @Test
    public void ShouldReturnColaborators() {

        ColaboratorTO colaborators = this.colaboratorsFacade.getColaboratorsByHero("ironman");

        Assert.assertEquals(2, colaborators.getEditors().size());
    }
}