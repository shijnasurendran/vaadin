package com.example.vaadin;

import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.UI;


@Theme("valo")
@SpringUI
public class View extends UI{
	
	@Autowired
	Hello h;

	@Override
	protected void init(VaadinRequest req) {
		TextField name=new TextField("enter name");
		Button b=new Button("submit");
		VerticalLayout l=new VerticalLayout(name, b);
		l.setSpacing(true);
		l.setMargin(true);
		setContent(l);
		
		b.addClickListener(e -> Notification.show(h.sayHello(name.getValue())));
	}
}
