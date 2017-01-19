package br.ucb.talp.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validaQtdInicial")
public class ValidaQtdInicial implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value != null) {
            Integer qtdInicial = Integer.valueOf(value.toString());
            if (qtdInicial < 0) {
                throw new ValidatorException(new FacesMessage("Quantidade nao pode ser menor que 0!"));
            }
        }
    }

}
