/*
Storybook: Open Source software for novelists and authors.
Copyright (C) 2008 - 2012 Martin Mustun

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package storybook.action;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import storybook.SbConstants.ViewName;
import storybook.controller.BookController;
import storybook.model.hbn.entity.AbstractEntity;
import storybook.toolkit.I18N;
import storybook.ui.MainFrame;

/**
 * @author martin
 *
 */
public class ShowInChronoViewAction extends AbstractEntityAction {

	public ShowInChronoViewAction(MainFrame mainFrame, AbstractEntity entity) {
		super(mainFrame, entity, I18N.getMsg("msg.show.in.chrono.view"), I18N
				.getIcon("icon.small.chrono.view"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.showView(ViewName.CHRONO);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				BookController ctrl = mainFrame.getBookController();
				ctrl.chronoShowEntity(entity);
			}
		});
	}
}
