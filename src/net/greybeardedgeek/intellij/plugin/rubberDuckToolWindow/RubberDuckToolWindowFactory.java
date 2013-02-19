package net.greybeardedgeek.intellij.plugin.rubberDuckToolWindow;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jdesktop.swingx.JXImageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Rich Freedman,
 * http://greybeardedgeek.net
 * 2013-02-18
 */
public class RubberDuckToolWindowFactory implements ToolWindowFactory {

    private ToolWindow toolWindow;
    private JPanel toolWindowContent;
    private JXImageView duckImageView;
    private JButton hideToolWindowButton;

    public RubberDuckToolWindowFactory() {
        hideToolWindowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             toolWindow.hide(null);
            }
        });
    }

    // Create the tool window content.
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        this.toolWindow = toolWindow;
        this.quack();
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(toolWindowContent, "", false);
        toolWindow.getContentManager().addContent(content);
    }

    public void quack() {
      duckImageView.setImage(new ImageIcon(getClass().getResource("/net/greybeardedgeek/intellij/plugin/rubberDuckToolWindow/duck.png")).getImage());
    }

}
