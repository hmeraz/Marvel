package mx.com.Marvel.services.service;

import mx.com.Marvel.commons.to.ColaboratorTO;
import mx.com.Marvel.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ColaboratorServiceTest extends BaseTest {

    @Test
    public void exampleTest() {

        ColaboratorTO colaborators = this.colaboratorService.getColaboratorByHero("ironman");

        Assert.assertEquals(2, colaborators.getEditors().size());
    }
}
