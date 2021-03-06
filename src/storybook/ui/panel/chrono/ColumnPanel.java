/*
Storybook: Scene-based software for novelists and authors.
Copyright (C) 2008 - 2011 Martin Mustun

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

package storybook.ui.panel.chrono;

import java.util.Date;
import java.util.List;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.hibernate.Session;
import storybook.model.BookModel;
import storybook.model.hbn.dao.SceneDAOImpl;
import storybook.model.hbn.entity.Scene;
import storybook.model.hbn.entity.Strand;
import storybook.toolkit.swing.label.VerticalLabelUI;
import storybook.ui.MainFrame;

@SuppressWarnings("serial")
public class ColumnPanel extends AbstractStrandDatePanel {

	public ColumnPanel(MainFrame mainFrame, Strand strand, Date date) {
		super(mainFrame, strand, date);
	}

	@Override
	public void init() {
	}

	@Override
	public void initUi() {
		try {
			MigLayout layout = new MigLayout("insets 1,fill", "[][grow]", "[top]");
			setLayout(layout);
			setOpaque(false);

			// date
			StrandDateLabel lbDate = new StrandDateLabel(strand, date);
			lbDate.setUI(new VerticalLabelUI(false));
			add(lbDate, "cell 0 0,growy");

			// scenes by strand and date
			BookModel model = mainFrame.getBookModel();
			Session session = model.beginTransaction();
			SceneDAOImpl sceneDao = new SceneDAOImpl(session);
			List<Scene> sceneList = sceneDao.findByStrandAndDate(strand, date);
			model.commit();
			if (sceneList.isEmpty()) {
				SpacePanel spacePanel = new SpacePanel(mainFrame, strand, date);
				add(spacePanel, "grow");
			} else {
				MigLayout layout2 = new MigLayout("wrap,insets 0", "[]", "[top]");
				JPanel rowPanel = new JPanel(layout2);
				rowPanel.setOpaque(false);
				for (Scene scene : sceneList) {
					ChronoScenePanel csp = new ChronoScenePanel(mainFrame, scene);
					rowPanel.add(csp, "grow");
				}
				add(rowPanel, "grow");
			}
		} catch (Exception e) {
		}
	}
}
