package com.moneyxchange.app.resources;

import com.moneyxchange.app.consts.InstanceConstants;
import com.moneyxchange.app.resources.model.RateResumeModel;
import com.moneyxchange.app.resources.model.ResponseModel;
import com.moneyxchange.app.services.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.moneyxchange.app.consts.Constants.*;

@RestController
public class AppResource {

    @Autowired
    @Qualifier(InstanceConstants.RATE_SERVICE_IMPL)
    private RateService rateService;

    @GetMapping(path = PATH_BASE)
    public String sayHello(){
        return "Hello friends!";
    }

    @GetMapping(path = PATH_LATEST)
    public ResponseModel<RateResumeModel> latest(
            @RequestParam(PARAM_BASE) String base,
            @RequestParam(value = PARAM_SYMBOLS, required = false) String symbols) {
        Optional<RateResumeModel> optResume =
                StringUtils.hasText(symbols) ?
                        rateService.getLatest(base, symbols) :
                        rateService.getLatest(base);

        RateResumeModel resume = optResume.orElse(null);

        return new ResponseModel<RateResumeModel>(resume);
    }

}
