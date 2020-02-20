package com.nordryd.springexample.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * I'm gonna build my own web app, with blackjack! And hookers! In fact, forget the web app and the hookers!
 * </p>
 *
 * @author Nordryd
 */
@RestController
@RequestMapping("/blackjack")
public class BlackjackController
{
    private final BlackjackService service;

    @Autowired
    public BlackjackController(final BlackjackService service) {
        this.service = service;
    }
}
