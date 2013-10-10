package com.google.jplurk_oauth.example;

import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.jplurk_oauth.module.Alerts;
import com.google.jplurk_oauth.skeleton.PlurkOAuth;

/*
 import org.json.simple.parser.*;
 import org.json.simple.*;

 import net.sf.json.JSONArray;
 */

public class Example {
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		String ConsumerKey = "4XkuRdvvCi3y";
		String ConsumerSecret = "iJCEyFt7RLsjZiUZgBpVsBT3aAEp5owr";
		String TokenKey = "nomBuJrXeeec";
		String TokenSecret = "2x3PXr09gL7sQl24rpCq0iaYJQv6y0lF";
		/* create oauth config */
		PlurkOAuth auth = new PlurkOAuth(ConsumerKey, ConsumerSecret, TokenKey,
				TokenSecret);

		// post a plurk
		// System.out.println(auth.using(Timeline.class).plurkAdd("趁著夜色疾行的途中，你突然警覺到一股難聞的氣味從上風處飄來，而你認得這個氣味，你連忙使了個眼色要同伴們停下腳步",
		// Qualifier.FREESTYLE));

		// get all plurks
		// System.out.println(auth.using(Timeline.class).getPlurks());

		// get specific plurk
		// System.out.println(auth.using(Timeline.class).getPlurk(1121830598l));

		// delete a specific plurk
		// System.out.println(auth.using(Timeline.class).plurkDelete(1121945703l));

		// get responses from a specific plurk
		// System.out.println(auth.using(Responses.class).get(1121945748l));

		// delete response from a specific plurk
		// System.out.println(auth.using(Responses.class).responseDelete(5497127873l,
		// 1121945748l));

		// get someone's profile
		// System.out.println(auth.using(Profile.class).getPublicProfile(8464103l));

		// send a response
		// String msg="(bz)(bz)(bz)(bz)(bz)(bz)";
		// System.out.println(auth.using(Responses.class).responseAdd(1121945748l,
		// msg, Qualifier.FREESTYLE));

		// get active alerts
		// System.out.println(auth.using(Alerts.class).getActive());
		// try {
		try {
			JSONArray a = auth.using(Alerts.class).getActive();
			JSONObject b = a.getJSONObject(0);
			String c = b.getString("type");
			System.out.println(c);
			System.out.println(a.length());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
