package com.ganacharyas.ziprange.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ganacharyas.ziprange.model.ZipRange;
import com.ganacharyas.ziprange.service.ZipRangeService;

/**
 * Class providing API to process ZipRange resource
 * @author Santosh Ganacharya
 *
 */
@RestController
@RequestMapping(value = "/ziprange")
public class ZipRangeResource {

	private static final Logger logger = LoggerFactory.getLogger(ZipRangeResource.class);

	@Autowired
	private ZipRangeService zipRangeService;

	@RequestMapping(path = "/merge", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> merge(@RequestBody(required = true) String ranges) throws Exception {
		logger.info("Ranges received : {}", ranges);
		List<ZipRange> result = zipRangeService.mergeRanges(ranges);
		StringBuffer buff = new StringBuffer();
		result.forEach(range -> {
			buff.append(range + " ");
		});
		return ResponseEntity.ok(buff.toString());
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<String> otherExceptionOccured(Exception ex) {
		logger.error(ex.getMessage());
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
