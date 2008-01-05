/**
 * Created on 2008-1-5 下午03:24:04
 */
package com.redv.jdigg.domain;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sutra
 * 
 */
public class StoryTest {
	private Story story;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		story = new Story();
	}

	/**
	 * {@link com.redv.jdigg.domain.Story#getDate()} 的测试方法。
	 */
	@Test
	public void testGetDate() {
		// Default is not null as it should be initialized in its constructor.
		assertNotNull(story.getDate());

		// Set as now.
		Date now = new Date();
		story.setDate(now);
		assertEquals(now, story.getDate());

		// Set as null.
		story.setDate(null);
		assertNull(story.getDate());
	}

	/**
	 * {@link com.redv.jdigg.domain.Story#setDate(java.util.Date)} 的测试方法。
	 * 
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testSetDate() throws IllegalArgumentException,
			SecurityException, IllegalAccessException, NoSuchFieldException {
		// New a date and backup it.
		Date now = new Date();
		Date backup = (Date) now.clone();

		// Set for story, and modify the field of the story.
		story.setDate(now);
		Field field = story.getClass().getDeclaredField("date");
		field.setAccessible(true);
		Date fieldDate = (Date) field.get(story);
		fieldDate.setTime(0);

		// Check values.
		assertEquals(backup, now);
		assertEquals(fieldDate, story.getDate());
		assertFalse(fieldDate.getTime() == backup.getTime());
	}
}
