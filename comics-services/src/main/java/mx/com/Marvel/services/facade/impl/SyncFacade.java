package mx.com.Marvel.services.facade.impl;

import mx.com.Marvel.services.facade.ISyncFacade;
import mx.com.Marvel.services.service.IApiMarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SyncFacade implements ISyncFacade {

    @Autowired
    private IApiMarvelService apiMarvelService;

    public void sync() {
        this.apiMarvelService.sync();
    }
}
