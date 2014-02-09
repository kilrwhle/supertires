/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.supershiny.web.wicket.pages.admin;

import kz.supershiny.core.model.Tire;
import kz.supershiny.core.util.Constants;
import kz.supershiny.web.wicket.pages.BasePage;
import kz.supershiny.web.wicket.pages.HomePage;
import kz.supershiny.web.wicket.panels.DefaultContentPanel;
import kz.supershiny.web.wicket.panels.LoginPanel;
import kz.supershiny.web.wicket.panels.admin.CatalogEditorPanel;
import kz.supershiny.web.wicket.panels.admin.SimpleTiresListPanel;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author aishmanov
 */
public class CatalogEditorPage extends BasePage {
    
    private LoginPanel loginPanel;
    private Panel itemEditor;
    private Panel listPanel;
    
    public CatalogEditorPage() {
        this(null);
    }

    public CatalogEditorPage(Tire tire) {
        super();
        
        loginPanel = new LoginPanel("loginPanel");
        add(loginPanel.setOutputMarkupId(true));
        
        if(getUser() == null) {
            loginPanel.setVisible(true);
            itemEditor = new DefaultContentPanel("editorPanel");
            listPanel = new DefaultContentPanel("listPanel");
        } else {
            if(getUser().getPhone().equals(Constants.ADMIN_PHONE)) {
                loginPanel.setVisible(false);
                itemEditor = new CatalogEditorPanel("editorPanel", tire);
                listPanel = new SimpleTiresListPanel("listPanel");
            } else {
                setResponsePage(HomePage.class);
            }
        }
        add(itemEditor.setOutputMarkupId(true));
        add(listPanel.setOutputMarkupId(true));
    }
    
}