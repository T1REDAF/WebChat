package com.T1REDAF.view.chat;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.context.SecurityContextHolder;

@Route("")
public class MainView extends VerticalLayout {

    private Button button = new Button("Click");

    public MainView() {
        button.addClickListener(e -> add(new H3("Hello world!")));

        add(button,new H1("buc123"));

    }
}
