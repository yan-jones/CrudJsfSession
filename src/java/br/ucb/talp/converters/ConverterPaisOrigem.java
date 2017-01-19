package br.ucb.talp.converters;

import br.ucb.talp.beans.PaisOrigem;
import br.ucb.talp.daos.PaisOrigemDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("converterPaisOrigem")
public class ConverterPaisOrigem implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!(value == null && value.isEmpty())) {
            return new PaisOrigemDAO().selectByName(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && value instanceof PaisOrigem) {
            PaisOrigem paisOrigem = (PaisOrigem) value;
            return paisOrigem.getNome().toString();
        }
        return null;
    }

}
