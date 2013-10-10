package idv.plurk.rpg.job;

import idv.plurk.rpg.HomeController;
import idv.plurk.rpg.util.jPlurkUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	public void test() throws Exception {
		jPlurkUtil.checkNewFriend();
		logger.debug("check new friend");
	}
}
