package br.ucb.talp.service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JavaUtil {

    public static void message(String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
    }
}
