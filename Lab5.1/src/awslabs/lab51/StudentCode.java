/**
 * Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0/
 * 
 * or in the "LICENSE" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package awslabs.lab51;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * Project: Lab5.1
 */
public class StudentCode extends SolutionCode {

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
		// TODO Auto-generated method stub
		return super.getUrlForItem(s3Client, key, bucket);
	}

	/**
	 * GetImageItems
	 * 
	 * @param dynamoDbClient
	 * @return
	 */
	@Override
	public List<Map<String, AttributeValue>> getImageItems(AmazonDynamoDBClient dynamoDbClient) {
		// TODO Auto-generated method stub
		return super.getImageItems(dynamoDbClient);
	}

	/**
	 * CreateS3Client
	 * 
	 * @param credentials
	 * @return
	 */
	@Override
	public AmazonS3Client createS3Client(AWSCredentials credentials) {
		// TODO Auto-generated method stub
		return super.createS3Client(credentials);
	}

	/**
	 * CreateDynamoDbClient
	 * 
	 * @param credentials
	 * @return
	 */
	@Override
	public AmazonDynamoDBClient createDynamoDbClient(AWSCredentials credentials) {
		// TODO Auto-generated method stub
		return super.createDynamoDbClient(credentials);
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
		super.addItemsToPage(s3Client, items);
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
		return super.isImageInDynamo(dynamoDbClient, tableName, key);
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
		return super.validateSchema(tableDescription);
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
		return super.getTableDescription(ddbClient, tableName);
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
		return super.getTableStatus(ddbClient, tableName);
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
		super.waitForStatus(ddbClient, tableName, status);
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
		super.deleteTable(ddbClient, tableName);
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
		super.addImage(dynamoDbClient, tableName, s3Client, bucketName, imageKey, filePath);
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
		super.buildTable(ddbClient, tableName);
	}

}
