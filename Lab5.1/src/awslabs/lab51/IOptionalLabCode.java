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

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.TableDescription;
import com.amazonaws.services.s3.AmazonS3Client;

/**
 * Project: Lab5.1
 */
public interface IOptionalLabCode {
    Boolean IsImageInDynamo(AmazonDynamoDBClient dynamoDbClient, String tableName, String key);
    Boolean ValidateSchema(TableDescription tableDescription);
    TableDescription GetTableDescription(AmazonDynamoDBClient ddbClient, String tableName);
    String GetTableStatus(AmazonDynamoDBClient ddbClient, String tableName);
    void WaitForStatus(AmazonDynamoDBClient ddbClient, String tableName, String status);
    void DeleteTable(AmazonDynamoDBClient ddbClient, String tableName);

    void AddImage(AmazonDynamoDBClient dynamoDbClient, String tableName, AmazonS3Client s3Client, String bucketName,
        String imageKey, String filePath);

    void BuildTable(AmazonDynamoDBClient ddbClient, String tableName);
}
