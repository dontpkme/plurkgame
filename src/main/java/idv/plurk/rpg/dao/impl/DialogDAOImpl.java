package idv.plurk.rpg.dao.impl;

import idv.plurk.rpg.dao.DialogDAO;
import idv.plurk.rpg.model.Dialog;
import idv.plurk.rpg.util.DBUtil;

import org.springframework.stereotype.Component;

@Component
public class DialogDAOImpl implements DialogDAO {

	@Override
	public Dialog find(int id) {
		try {
			String sql = "select * from `dialog` where `id`="
					+ String.valueOf(id);
			return (Dialog) DBUtil.findOne(new Dialog(), sql);
		} catch (Exception e) {
			return null;
		}
	}
}
