package idv.plurk.rpg.util;

import idv.plurk.rpg.HomeController;
import idv.plurk.rpg.model.User;

import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.jplurk_oauth.Qualifier;
import com.google.jplurk_oauth.module.Alerts;
import com.google.jplurk_oauth.module.FriendsFans;
import com.google.jplurk_oauth.module.Responses;
import com.google.jplurk_oauth.module.Timeline;
import com.google.jplurk_oauth.skeleton.Args;
import com.google.jplurk_oauth.skeleton.PlurkOAuth;
import com.google.jplurk_oauth.skeleton.RequestException;

public class jPlurkUtil {

	private final static Properties prop = System.getProperties();
	private final static String ConsumerKey = "4XkuRdvvCi3y";
	private final static String ConsumerSecret = "iJCEyFt7RLsjZiUZgBpVsBT3aAEp5owr";
	private final static String TokenKey = "nomBuJrXeeec";
	private final static String TokenSecret = "2x3PXr09gL7sQl24rpCq0iaYJQv6y0lF";
	private final static PlurkOAuth auth = new PlurkOAuth(ConsumerKey,
			ConsumerSecret, TokenKey, TokenSecret);

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	public static void checkNewFriend() throws Exception {
		JSONArray alerts = auth.using(Alerts.class).getActive();
		if (alerts.length() > 0) {
			for (int i = 0; i < alerts.length(); i++) {
				JSONObject alert = alerts.getJSONObject(i);
				String alert_type = alert.getString("type");

				if (alert_type.equals("friendship_request")) {
					// System.out.println(alert);
					User user = new User();
					user.setId(alert.getJSONObject("from_user").getLong("id"));
					user.setDisplayname(alert.getJSONObject("from_user")
							.getString("display_name"));
					user.setNickname(alert.getJSONObject("from_user")
							.getString("nick_name"));

					auth.using(FriendsFans.class).becomeFriend(user.getId());
					auth.using(FriendsFans.class).setFollowing(user.getId(),
							false);

					long[] users = { user.getId() };
					long id = plurkToUser("[dialog] 歡迎加入噗浪冒險者公會",
							Qualifier.SAYS, users);
					responsePlurk(id, "hello world", Qualifier.HAS);
					logger.info("has new friend [" + user.getDisplayname()
							+ "]");
				}
			}
		}
	}

	public static long plurkToUser(String content, Qualifier qualifier,
			long[] users) throws RequestException, JSONException {
		Args args = new Args();
		JSONArray array = new JSONArray();
		for (int i = 0; i < users.length; i++)
			array.put(users[i]);
		args.add("limited_to", array);
		JSONObject json = auth.using(Timeline.class).plurkAdd(content,
				qualifier, args);
		return json.getLong("plurk_id");
	}

	public static long plurkPublic(String content, Qualifier qualifier)
			throws RequestException, JSONException {
		JSONObject json = auth.using(Timeline.class).plurkAdd(content,
				qualifier);
		return json.getLong("plurk_id");
	}

	public static long responsePlurk(long plurkId, String content,
			Qualifier qualifier) throws RequestException, JSONException {
		JSONObject json = auth.using(Responses.class).responseAdd(plurkId,
				content, qualifier);
		return json.getLong("id");
	}
}