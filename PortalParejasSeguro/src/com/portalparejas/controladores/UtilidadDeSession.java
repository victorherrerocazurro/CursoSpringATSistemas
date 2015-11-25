package com.portalparejas.controladores;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component("utilleria")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UtilidadDeSession {

}
