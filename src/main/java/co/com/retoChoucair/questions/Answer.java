package co.com.retoChoucair.questions;

import co.com.retoChoucair.model.UtestData;
import co.com.retoChoucair.userinterface.MapCreate;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;

public class Answer implements Question<Boolean> {

    private List<UtestData> utestData;

    public Answer(List<UtestData> utestData) {
        this.utestData = utestData;
    }

    public static Answer verify(List<UtestData> utestData) {
        return new Answer(utestData);
    }



    @Override
    public Boolean answeredBy(Actor actor) {

        boolean resultado;

        String usuarioNew = Text.of(MapCreate.USER_OK).viewedBy(actor).asString();

        if (utestData.get(0).getConfirm().equals(usuarioNew)){
            resultado = true;
        }else {
            resultado = false;
        }

        return resultado;
    }
}
