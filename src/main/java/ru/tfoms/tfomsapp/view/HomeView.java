package ru.tfoms.tfomsapp.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tfoms.tfomsapp.repo.KMS.PlatelRepo;
import ru.tfoms.tfomsapp.annotation.EbanaCarebana;
import ru.tfoms.tfomsapp.domain.KMS.Platel;
import ru.tfoms.tfomsapp.domain.TfomsMenu;

import javax.annotation.security.PermitAll;
import java.sql.SQLException;
import java.util.List;

@Route("home")
@PermitAll
public class HomeView extends Div {

    private Grid<Platel> grid = new Grid<>();

    @Autowired
    private PlatelRepo platelRepo;


    @EbanaCarebana
    public HomeView() {
        grid.addColumn(Platel::getNamef).setHeader("Полное наименование").setFrozen(true)
                .setResizable(true).setFlexGrow(0).setSortable(true);
        grid.addColumn(Platel::getNamesc).setHeader("Короткое наименовение").setResizable(true).setSortable(true);
        grid.addColumn(Platel::getInn).setHeader("ИНН").setResizable(true).setSortable(true);
        grid.addColumn(Platel::getKpp).setHeader("КПП").setResizable(true).setSortable(true);
        grid.addColumn(Platel::getOgrn).setHeader("ОГРН").setResizable(true).setSortable(true);
        grid.addColumn(Platel::getAddrss).setHeader("Адрес").setResizable(true).setSortable(true);
        grid.addColumn(Platel::getStatus).setHeader("Статус").setResizable(true).setSortable(true);

        Dialog dialog = new Dialog();
        dialog.getElement().setAttribute("aria-label", "Employee list");

        VerticalLayout dialogLayout = createDialogLayout(dialog);
        dialog.add(dialogLayout);
        dialog.setDraggable(true);
        dialog.setResizable(true);
        dialog.setCloseOnOutsideClick(false);

        Button button = new Button("Show dialog", e -> dialog.open());
        Button btnLoadToGird = new Button("Load to Grid", e -> {
            try {
                LoadToGrid();
                //UI.getCurrent().getPage().executeJs( "print();" );
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        add(new TfomsMenu().createMenu(), dialog, button, btnLoadToGird, grid);
    }

    private static VerticalLayout createDialogLayout(Dialog dialog) {
        H2 headline = new H2("Employee list");
        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
                .set("font-size", "1.5em").set("font-weight", "bold");

        Label label = new Label("Какой-то текст");
        Button button1 = new Button("test");
        button1.addClickListener(e -> dialog.close());

        VerticalLayout dialogLayout = new VerticalLayout(headline, label, button1);
        dialogLayout.setPadding(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        dialogLayout.getStyle().set("min-width", "300px")
                .set("max-width", "100%").set("height", "100%");

        return dialogLayout;
    }

    private void LoadToGrid() throws SQLException {
        List<Platel> platel = platelRepo.findAll();
//        PlatelDAO platelDAO = new PlatelDAOImpl();
//        platelDAO.setDataSource(new DBConfig().ConnectToKMS());
        //var platel = platelDAO.listPlatels();
        grid.setItems(platel);
    }
}
