package com.ganacharyas.ziprange.service;

import java.util.List;

import com.ganacharyas.ziprange.model.ZipRange;

/**
 * Interface specifying signatures to process zipRanges
 * @author Santosh Ganacharya
 *
 */
public interface ZipRangeService {
	
	public List<ZipRange> mergeRanges(String zipRanges) throws Exception;
	
}
