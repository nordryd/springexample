package com.nordryd.springexample.colorcalculator;

import com.nordryd.springexample.colorcalculator.service.ColorCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * REST endpoints for the Color Calculator app.
 * </p>
 */
@RestController
@RequestMapping("/colorcalc")
public class ColorCalculatorController
{
    private final ColorCalculatorService service;

    @Autowired
    public ColorCalculatorController(final ColorCalculatorService service) {
        this.service = service;
    }

    @GetMapping("/add/{color1}/{color2}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String addColors(@PathVariable("color1") final String color1, @PathVariable("color2") final String color2) {
        return service.addColors(color1, color2);
    }
}
