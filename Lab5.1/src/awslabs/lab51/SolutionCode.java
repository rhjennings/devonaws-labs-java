/** 
 * Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not 
 * use this file except in compliance with the License. A copy of the License 
 * is located at
 * 
 * 	http://aws.amazon.com/apache2.0/
 * 
 * or in the "LICENSE" file accompanying this file. This file is distributed 
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package awslabs.lab51;

import java.net.URL;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;

/**
 * Project: Lab5.1
 */
public abstract class SolutionCode implements ILabCode, IOptionalLabCode {

	/**
	 * GetUrlForItem
	 * 
	 * @param s3Client
	 * @param key
	 * @param bucket
	 * @return
	 */
	@Override
	public String getUrlForItem(AmazonS3Client s3Client, String key, String bucket) {
    	Date nowPlusTwoMinutes = new Date(System.currentTimeMillis() + 2000L);
    	
    	// Construct a GeneratePresignedUrlRequest object for the provided object.
    	GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, key);
    	// Set the expiration value in the request to the nowPlusOneHour object 
    	// (this specifies a time one hour from now). 
    	generatePresignedUrlRequest.setExpiration(nowPlusTwoMinutes);
    	
        // Submit the request using the generatePresignedUrl method of the s3Client object.
    	URL url = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
    	// Return the URL as a string.
        return url.toString();
	}

	/**
	 * GetImageItems
	 * 
	 * @param dynamoDbClient
	 * @return
	 */
	@Override
	public List<Map<String, AttributeValue>> getImageItems(AmazonDynamoDBClient dynamoDbClient) {
		try {
    		String tableName = System.getProperty("SESSIONTABLE");
    		String keyPrefix = System.getProperty("PARAM3");
    		
    		Map<String,Condition> scanFilter = new HashMap<String, Condition>();
    		scanFilter.put("Key", new Condition().withAttributeValueList(new AttributeValue().withS(keyPrefix)).withComparisonOperator("BEGINS_WITH"));
    		ScanRequest scanRequest = new ScanRequest(tableName).withSelect("ALL_ATTRIBUTES").withScanFilter(scanFilter);
    		
    		return dynamoDbClient.scan(scanRequest).getItems();
		}
		catch (Exception ex) {
			// TODO: RHY - Do the equivalent of this:
			//			_Default.LogMessageToPage("GetImageItems Error: {0}", ex.Message);
			return null;
		}
	}

	/**
	 * CreateS3Client
	 * 
	 * @param credentials
	 * @return
	 */
	@Override
	public AmazonS3Client createS3Client(AWSCredentials credentials) {
	    Region region = Region.getRegion(Regions.fromName(System.getProperty("REGION")));
	    AmazonS3Client client = new AmazonS3Client();
	    client.setRegion(region);

		return client;
	}

	/**
	 * CreateDynamoDbClient
	 * 
	 * @param credentials
	 * @return
	 */
	@Override
	public AmazonDynamoDBClient createDynamoDbClient(AWSCredentials credentials) {
	    Region region = Region.getRegion(Regions.fromName(System.getProperty("REGION")));
	    AmazonDynamoDBClient client = new AmazonDynamoDBClient();
	    client.setRegion(region);

		return client;
	}

	/**
	 * AddItemsToPage
	 * 
	 * @param s3Client
	 * @param items
	 */
	@Override
	public void addItemsToPage(AmazonS3Client s3Client, List<Dictionary<String, AttributeValue>> items) {
		// TODO Auto-generated method stub

	}


	/**
	 * IsImageInDynamo
	 * 
	 * @param dynamoDbClient
	 * @param tableName
	 * @param key
	 * @return
	 */
	@Override
	public Boolean isImageInDynamo(AmazonDynamoDBClient dynamoDbClient, String tableName, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ValidateSchema
	 * 
	 * @param tableDescription
	 * @return
	 */
	@Override
	public Boolean validateSchema(TableDescription tableDescription) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * GetTableDescription
	 * 
	 * @param ddbClient
	 * @param tableName
	 * @return
	 */
	@Override
	public TableDescription getTableDescription(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * GetTableStatus
	 * 
	 * @param ddbClient
	 * @param tableName
	 * @return
	 */
	@Override
	public String getTableStatus(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * WaitForStatus
	 * 
	 * @param ddbClient
	 * @param tableName
	 * @param status
	 */
	@Override
	public void waitForStatus(AmazonDynamoDBClient ddbClient, String tableName, String status) {
		// TODO Auto-generated method stub

	}

	/**
	 * DeleteTable
	 * 
	 * @param ddbClient
	 * @param tableName
	 */
	@Override
	public void deleteTable(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO Auto-generated method stub

	}

	/**
	 * AddImage
	 * 
	 * @param dynamoDbClient
	 * @param tableName
	 * @param s3Client
	 * @param bucketName
	 * @param imageKey
	 * @param filePath
	 */
	@Override
	public void addImage(AmazonDynamoDBClient dynamoDbClient, String tableName, AmazonS3Client s3Client,
			String bucketName, String imageKey, String filePath) {
		// TODO Auto-generated method stub

	}

	/**
	 * BuildTable
	 * 
	 * @param ddbClient
	 * @param tableName
	 */
	@Override
	public void buildTable(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO Auto-generated method stub

	}

}
