# ZipRangeService
### What is this repository for? ###
BACKGROUND

Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5-digit codes. 

For example, if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

PROBLEM

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input. 

NOTES

- The ranges above are just examples, your implementation should work for any set of arbitrary ranges
- Ranges may be provided in arbitrary order
- Ranges may or may not overlap
- Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

EXAMPLES

If the input = [94133,94133] [94200,94299] [94600,94699]
Then the output should be = [94133,94133] [94200,94299] [94600,94699]

If the input = [94133,94133] [94200,94299] [94226,94399]
Then the output should be = [94133,94133] [94200,94399]

Evaluation Guidelines

Your work will be evaluated against the following criteria:
- Successful implementation
- Efficiency of the implementation
- Design choices and overall code organization
- Code quality and best practices

### How do I get set up? ###
Prerequisites :
	1) JAVA 1.8+
	
###Steps to setup and run :
1) To build run following command
	mvn clean install
2) To start application, run following command
	java -jar target\ZipRangeService-0.0.1-SNAPSHOT.jar
	
### How to access?
Use url http://localhost:8080/swagger-ui.htm to access swagger-ui to to operations using REST API's

### What is the API which is solved mentioned problem? Example?
1) From Swagger UI  use : http://localhost:8080/swagger-ui.html#!/zip45range45resource/mergeUsingPOST
2) From REST Client use following
	*Request Details
	  URL - http://localhost:8080/ziprange/merge
	  Payload - [94133,94133] [94200,94299] [94226,94399]
	*Response Details
		Response Code : 200
		Response Body : [94133,94133] [94200,94399]
		
  
