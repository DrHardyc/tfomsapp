package ru.tfoms.tfomsapp.domain;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.RouterLink;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.tfoms.tfomsapp.view.*;

import java.util.ArrayList;
import java.util.List;

public class TfomsMenu {

    public Tabs createMenu() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.setId("tabs");
        if (CheckRole().contains("USER")) {
            tabs.add(createTab("Домой", HomeView.class));
            tabs.add(createTab("Загрузка *.csv", LoadCSVView.class));
            tabs.add(createTab("Загрузка *.xml", LoadXMLView.class));
        }
        if (CheckRole().contains("ADMIN")) {
            tabs.add(createTab("Admin", AdminView.class));
        }
        if (CheckRole().contains("USER")){
            tabs.add(createTab("Logout", LogoutView.class));
        }

        return tabs;
    }

    private List<String> CheckRole() {
        List<String> result = new ArrayList();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_USER"))) {
            result.add("USER");
        }
        if (auth.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            result.add("ADMIN");
        }
        return result;
    }
    private static Tab createTab(String text, Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }

}
