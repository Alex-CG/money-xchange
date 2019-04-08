package com.moneyxchange.app.resources;

import com.moneyxchange.app.consts.Constants;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppErrorResource implements ErrorController {

    @Override
    public String getErrorPath() {
        return Constants.PATH_ERROR;
    }

    @GetMapping()
    public String error() {
        return "It is not you, it's us :c";
    }

}
