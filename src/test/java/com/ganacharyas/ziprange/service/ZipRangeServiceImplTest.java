/**
 * 
 */
package com.ganacharyas.ziprange.service;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.util.List;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ganacharyas.ziprange.model.ZipRange;

/**
 * @author Santosh Ganacharya
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipRangeServiceImplTest {
	
	@Autowired
	private ZipRangeServiceImpl zipRangeServiceImpl;

	@Test
	public void success() throws Exception {
		List<ZipRange> result = zipRangeServiceImpl.mergeRanges("[10000,14999] [12456,19999]");
		assertEquals(1,result.size());
		assertEquals("[10000,19999]",result.get(0).toString());
	}
	
	@Test(expected=Exception.class)
	public void fail() throws Exception {
		List<ZipRange> result = zipRangeServiceImpl.mergeRanges("[10000,14999][12456,19999]");
	}

}
