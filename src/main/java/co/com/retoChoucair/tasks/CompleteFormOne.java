package co.com.retoChoucair.tasks;

import co.com.retoChoucair.model.UtestData;
import co.com.retoChoucair.userinterface.MapFormOne;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

public class CompleteFormOne implements Task {

    private List<UtestData> utestData;

    public CompleteFormOne(List<UtestData> utestData) {
        this.utestData = utestData;
    }

    public static CompleteFormOne formOne(List<UtestData> utestData) {

        return Tasks.instrumented(CompleteFormOne.class, utestData);

    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Scroll.to(MapFormOne.NEXT_LOCATION),
                Enter.theValue(utestData.get(0).getFirstName()).into(MapFormOne.FIRST_NAME),
                Enter.theValue(utestData.get(0).getLastName()).into(MapFormOne.lAST_NAME),
                Enter.theValue(utestData.get(0).getEmail()).into(MapFormOne.EMAIL),
                Click.on(MapFormOne.MONTH),
                Click.on(MapFormOne.DAY),
                Click.on(MapFormOne.YEAR),
                Click.on(MapFormOne.NEXT_LOCATION)
        );

    }
}
