package com.github.tobiasrm;

import org.pmw.tinylog.Logger;


/** Main class for color demo. 
 */
public class Main {


	public static void main(String[] args) {

		// source coude generate level tag
		final String preLevelTag = "[[preLevelTag]]";
		final String postLevelTag = "[[postLevelTag]]";

		// for "1 default example" and "2 log-level decoration example" (see tinylog.properties) 
		Logger.trace("hello trace-world");
		Logger.debug("hello debug-world");
		Logger.info("hello info-world");
		Logger.warn("hello warn-world");
		//		Logger.warn("hello warn-world with {}source code generated{} 'misuse' of the level tag", preLevelTag, postLevelTag);
		Logger.error("hello error-world");


		// for "3 custom tag usage example" (see tinylog.properties)
		//		Logger.info("Example 1 - sequential tag replacement:   [[someCustomPreTag]] some text [[someCustomPostTag]] and possibly some other text");
		//		Logger.info("Example 2 - coloring of tag occurrence:   ----- pre-init (phase 1) ----- and possibly some other text");
		//		Logger.info("Example 3 - coloring within a tag:        <---- init (phase 2) ----> and possibly some other text");
		//		Logger.info("Example 4 - coloring of tagged content:   <==== init DONE ====> and possibly some other text");
		//		Logger.info("Example 5 - coloring or arbitrary strings: UNCAUGHT EXCEPTION: error in some class");
	}

}
