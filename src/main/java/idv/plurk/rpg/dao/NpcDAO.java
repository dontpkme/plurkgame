package idv.plurk.rpg.dao;

import idv.plurk.rpg.model.Emotion;
import idv.plurk.rpg.model.Emotion.Emote;
import idv.plurk.rpg.model.Npc;

public interface NpcDAO {

	public Npc find(int id);

	public Emotion getNpcEmotion(int npcId, Emote emote);
}
