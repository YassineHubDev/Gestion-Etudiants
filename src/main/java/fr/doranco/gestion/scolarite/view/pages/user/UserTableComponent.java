/**
 * 
 */
package fr.doranco.gestion.scolarite.view.pages.user;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fr.doranco.gestion.scolarite.entity.User;

/**
 * @author Aguedo Claudio
 *
 */
public class UserTableComponent extends JTable implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7948854003246675240L;

	public UserTableComponent() {
		this.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	JTable table = (JTable) evt.getComponent();
		        int row = table.rowAtPoint(evt.getPoint());
		        int col = 6; // column id
		        if (row >= 0) {
		           int id = (int) table.getModel().getValueAt(row, col);
		           new UpdateUserModalComponent(null, id).setVisible(true);
		        }
		    }
		});
	}
	
	@Override
	public void update(Observable o, Object obj) {
		Object[][] data = transform(obj);
		String[] columnsName = new String[]{"Profil", "Nom", "Prenom", "Email", "Genre", "Date de naissance", "ID"};
		DefaultTableModel model = new DefaultTableModel(data, columnsName);
		this.setModel(model);
		this.removeColumn(this.getColumnModel().getColumn(6));
		this.resizeAndRepaint();
	}
	

	@SuppressWarnings("unchecked")
	protected Object[][] transform(Object data) {
		List<User> users = (List<User>) data; 
		Object[][] result = new Object[users.size()][7];
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			result[i][0] = user.getProfile();
			result[i][1] = user.getLastname();
			result[i][2] = user.getFirstname();
			result[i][3] = user.getEmail();
			result[i][4] = user.getSex();
			result[i][5] = user.getDateBirth();
			result[i][6] = user.getId();
		}
		return result;
	}
	
	public boolean isCellEditable(int row, int column){  
        return false;  
    }
}
