package com.T1REDAF.view.chat;

import com.vaadin.collaborationengine.CollaborationAvatarGroup;
import com.vaadin.collaborationengine.CollaborationMessageInput;
import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.security.PermitAll;

@Route(value = "")
@PageTitle("Chat || Dinar")
@PermitAll
public class ChatView extends VerticalLayout {

    private CollaborationMessageList chatList;
    private CollaborationMessageInput messageInput;
    private CollaborationAvatarGroup avatarGroup;
    private final UserInfo userInfo;

    public ChatView() {

        var name = SecurityContextHolder.getContext().getAuthentication().getName();
        userInfo = new UserInfo(name,name);

        add(getAvatarLayout(),getChatLayout());

    }

    private Component getAvatarLayout() {

        var avatarLayout = new HorizontalLayout();

        avatarGroup = new CollaborationAvatarGroup(userInfo,"users");
        avatarGroup.getStyle().set("width", "unset");
        avatarLayout.add(avatarGroup);
        return avatarLayout;

    }

    private Component getChatLayout() {

        var chatLayout = new VerticalLayout();

        chatList = new CollaborationMessageList(userInfo,"chat");
        messageInput = new CollaborationMessageInput(chatList);
        chatList.setSizeUndefined();
        addClassName("bg-contrast-5");
        chatLayout.add(new H3("Chat | T1REDAF"));
        chatLayout.add(chatList);
        chatLayout.add(messageInput);

        chatLayout.setAlignItems(Alignment.CENTER);
        chatLayout.setJustifyContentMode(JustifyContentMode.CENTER);
        return  chatLayout;
    }
}
