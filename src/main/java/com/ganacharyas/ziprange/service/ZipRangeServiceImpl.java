package com.ganacharyas.ziprange.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ganacharyas.ziprange.model.ZipRange;
import com.ganacharyas.ziprange.util.AppUtil;

/**
 * Class implementing all services mentioned in ZipRangeService
 * @author Santosh Ganacharya
 *
 */
@Service
public class ZipRangeServiceImpl implements ZipRangeService {

	private Logger logger = LoggerFactory.getLogger(ZipRangeServiceImpl.class);
	
	/*
	 * Processes provided collection of ranges.
	 * (non-Javadoc)
	 * @see com.ganacharyas.ziprange.service.ZipRangeService#mergeRanges(java.lang.String)
	 */
	@Override
	public List<ZipRange> mergeRanges(String zipRanges) throws Exception {
		Objects.requireNonNull(zipRanges);
		zipRanges = zipRanges.trim();

		List<ZipRange> receivedRanges = new ArrayList<ZipRange>();
		logger.info("Ranges received : {}", zipRanges);
		String[] rangeArray = zipRanges.split(" ");

		for (String range : rangeArray) {
			range = range.trim();
			if(range.isEmpty()){
				continue;
			}
			if (!AppUtil.isValidRange(range)) {
				throw new Exception("Invalid range :" + range);
			}
			String[] splitedRange = range.split(",");
			int lower = Integer.parseInt(splitedRange[0].substring(1, splitedRange[0].length()));
			int upper = Integer.parseInt(splitedRange[1].substring(0, splitedRange[1].length() - 1));
			receivedRanges.add(new ZipRange(lower, upper));
		}
		return mergeRanges(receivedRanges);

	}

	/**
	 * Logic to merge ranges
	 * @param zipRanges
	 * @return
	 */
	private List<ZipRange> mergeRanges(List<ZipRange> zipRanges) {
		List<ZipRange> result = new ArrayList<ZipRange>();
		zipRanges.forEach(newRange -> {
			if (result.size() == 0)
				result.add(newRange);
			else {
				ListIterator<ZipRange> iter = result.listIterator();
				boolean add = true;
				while (iter.hasNext()) {
					ZipRange range = iter.next();
					if (range.getLower() <= newRange.getLower() && range.getUpper() >= newRange.getUpper()) {
						add = false;
					} else if (range.getLower() > newRange.getUpper() || range.getUpper() < newRange.getLower()) {
						add = true;
					} else {
						if (range.getLower() < newRange.getLower())
							newRange.setLower(range.getLower());
						if (range.getUpper() > newRange.getUpper())
							newRange.setUpper(range.getUpper());
						iter.remove();
						add = true;
					}
				}
				if (add)
					result.add(newRange);
			}
		});

		return result;
	}

}
