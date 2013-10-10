package idv.plurk.rpg.dao.impl;

import idv.plurk.rpg.dao.NpcDAO;
import idv.plurk.rpg.model.Emotion;
import idv.plurk.rpg.model.Emotion.Emote;
import idv.plurk.rpg.model.Npc;
import idv.plurk.rpg.util.DBUtil;

import org.springframework.stereotype.Component;

@Component
public class NpcDAOImpl implements NpcDAO {

	@Override
	public Npc find(int id) {
		try {
			String sql = "select * from `npc` where `id`=" + String.valueOf(id);
			return (Npc) DBUtil.findOne(new Npc(), sql);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Emotion getNpcEmotion(int npcId, Emote emote) {
		try {
			String sql = "select `url` from `emotion` where `npc`="
					+ String.valueOf(npcId) + " and `emote`='"
					+ emote.toString() + "'";
			return (Emotion) DBUtil.findOne(new Emotion(), sql);
		} catch (Exception e) {
			return null;
		}
	}
}
