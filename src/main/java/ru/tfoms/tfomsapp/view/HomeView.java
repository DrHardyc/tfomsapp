package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;

@Route("home")
@PermitAll
public class HomeView extends Div {
    public HomeView() {
        Dialog dialog = new Dialog();
        dialog.getElement().setAttribute("aria-label", "Employee list");

        VerticalLayout dialogLayout = createDialogLayout(dialog);
        dialog.add(dialogLayout);
        dialog.setDraggable(true);
        dialog.setResizable(true);

        Button button = new Button("Show dialog", e -> dialog.open());
        add(dialog, button);
    }

    private static VerticalLayout createDialogLayout(Dialog dialog) {
        H2 headline = new H2("Employee list");
        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");

        Label label = new Label("Какой-то текст");
        Button button1 = new Button("test");
        button1.addClickListener(e ->  dialog.close());

        VerticalLayout dialogLayout = new VerticalLayout(headline, label, button1);
        dialogLayout.setPadding(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("min-width", "300px")
                .set("max-width", "100%").set("height", "100%");

        return dialogLayout;
    }
}
