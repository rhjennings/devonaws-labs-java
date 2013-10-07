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

import java.util.Dictionary;
import java.util.List;

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
	public String GetUrlForItem(AmazonS3Client s3Client, String key, String bucket) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * GetImageItems
	 * 
	 * @param dynamoDbClient
	 * @return
	 */
	@Override
	public List<Dictionary<String, AttributeValue>> GetImageItems(AmazonDynamoDBClient dynamoDbClient) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * CreateS3Client
	 * 
	 * @param credentials
	 * @return
	 */
	@Override
	public AmazonS3Client CreateS3Client(AWSCredentials credentials) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * CreateDynamoDbClient
	 * 
	 * @param credentials
	 * @return
	 */
	@Override
	public AmazonDynamoDBClient CreateDynamoDbClient(AWSCredentials credentials) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * AddItemsToPage
	 * 
	 * @param s3Client
	 * @param items
	 */
	@Override
	public void AddItemsToPage(AmazonS3Client s3Client, List<Dictionary<String, AttributeValue>> items) {
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
	public Boolean IsImageInDynamo(AmazonDynamoDBClient dynamoDbClient, String tableName, String key) {
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
	public Boolean ValidateSchema(TableDescription tableDescription) {
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
	public TableDescription GetTableDescription(AmazonDynamoDBClient ddbClient, String tableName) {
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
	public String GetTableStatus(AmazonDynamoDBClient ddbClient, String tableName) {
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
	public void WaitForStatus(AmazonDynamoDBClient ddbClient, String tableName, String status) {
		// TODO Auto-generated method stub

	}

	/**
	 * DeleteTable
	 * 
	 * @param ddbClient
	 * @param tableName
	 */
	@Override
	public void DeleteTable(AmazonDynamoDBClient ddbClient, String tableName) {
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
	public void AddImage(AmazonDynamoDBClient dynamoDbClient, String tableName, AmazonS3Client s3Client,
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
	public void BuildTable(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO Auto-generated method stub

	}

}
