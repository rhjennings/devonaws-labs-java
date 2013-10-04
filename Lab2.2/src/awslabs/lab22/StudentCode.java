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
package awslabs.lab22;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

/**
 * Project: Lab2.2
 */

public class StudentCode extends SolutionCode {

	/**
	 * @param ddbClient The DynamoDB client object.
	 * @param tableName
	 */
	@Override
	public void deleteTable(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO: Replace this call to the super class with your own implementation of the method.
		super.deleteTable(ddbClient, tableName);
	}

	/**
	 * @param ddbClient The DynamoDB client object.
	 * @param tableName
	 */
	@Override
	public void buildTable(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO: Replace this call to the super class with your own implementation of the method.
		super.buildTable(ddbClient, tableName);
	}

	/**
	 * @param ddbClient The DynamoDB client object.
	 * @param tableName
	 * @return
	 */
	@Override
	public String getTableStatus(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO: Replace this call to the super class with your own implementation of the method.
		return super.getTableStatus(ddbClient, tableName);
	}

	/**
	 * @param ddbClient The DynamoDB client object.
	 * @param tableName
	 * @return
	 */
	@Override
	public TableDescription getTableDescription(AmazonDynamoDBClient ddbClient, String tableName) {
		// TODO: Replace this call to the super class with your own implementation of the method.
		return super.getTableDescription(ddbClient, tableName);
	}

	/**
	 * @param ddbClient The DynamoDB client object.
	 * @param tableName
	 * @param status
	 * @param timeout
	 */
	@Override
	public void waitForStatus(AmazonDynamoDBClient ddbClient, String tableName, String status) {
		// TODO: Replace this call to the super class with your own implementation of the method.
		super.waitForStatus(ddbClient, tableName, status);
	}

	/**
	 * @param ddbClient The DynamoDB client object.
	 * @param tableName
	 * @param account
	 */
	@Override
	public void createAccountItem(AmazonDynamoDBClient ddbClient, String tableName, Account account) {
		// TODO: Replace this call to the super class with your own implementation of the method.
		super.createAccountItem(ddbClient, tableName, account);
	}

	/**
	 * @param ddbClient The DynamoDB client object.
	 * @param tableName
	 * @param company
	 * @return
	 */
	@Override
	public QueryResult lookupByHashKey(AmazonDynamoDBClient ddbClient, String tableName, String company) {
		// TODO: Replace this call to the super class with your own implementation of the method.
		return super.lookupByHashKey(ddbClient, tableName, company);
	}

	/**
	 * @param ddbClient The DynamoDB client object.
	 * @param tableName
	 * @param email
	 * @param company
	 * @param firstNameTarget
	 * @param firstNameMatch
	 */
	@Override
	public void updateIfMatch(AmazonDynamoDBClient ddbClient, String tableName, String email, String company,
			String firstNameTarget, String firstNameMatch) {
		// TODO: Replace this call to the super class with your own implementation of the method.
		super.updateIfMatch(ddbClient, tableName, email, company, firstNameTarget, firstNameMatch);
	}
}
