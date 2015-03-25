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
package awslabs.lab31;

import java.util.List;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicRequest;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

/**
 * Project: Lab3.1
 */
public class StudentCode extends SolutionCode {

	/**
	 * Create an SQS queue using the queue name provided and return the URL for the new queue. Hint: Use the
	 * createQueue() method of the client object. The URL is in the response.
	 * 
	 * @param sqsClient The SQS Client object.
	 * @param queueName The name of the queue to create.
	 * @return The URL of the newly created queue.
	 */
	@Override
	public String createQueue(AmazonSQSClient sqsClient, String queueName) {
		CreateQueueRequest queueRequest = new CreateQueueRequest(queueName);
		
		return sqsClient.createQueue(queueRequest).getQueueUrl();
	}

	/**
	 * Query the SQS service for the ARN of the specified queue and return it. Hint: Use the getQueueAttributes() method
	 * of the client object. The attribute to request is named QueueArn.
	 * 
	 * @param sqsClient The SQS Client object.
	 * @param queueUrl The URL for the queue to inspect.
	 * @return A string containing the ARN for the queue.
	 */
	@Override
	public String getQueueArn(AmazonSQSClient sqsClient, String queueUrl) {
		GetQueueAttributesRequest request = new GetQueueAttributesRequest().withAttributeNames("QueueArn").withQueueUrl(queueUrl);
		GetQueueAttributesResult result = sqsClient.getQueueAttributes(request);
		
		return result.getAttributes().get("QueueArn");
	}

	/**
	 * Create an SNS topic and return the ARN for the newly created topic. Hint: Use the createTopic() method of the
	 * client object. The ARN for the topic is contained in the response.
	 * 
	 * @param snsClient The SNS client object.
	 * @param topicName The name of the topic to create.
	 * @return The ARN for the newly created topic.
	 */
	@Override
	public String createTopic(AmazonSNSClient snsClient, String topicName) {
		CreateTopicRequest request = new CreateTopicRequest().withName(topicName);
		CreateTopicResult result = snsClient.createTopic(request);
		
		return result.getTopicArn();
	}

	/**
	 * Create an SNS subscription that publishes notifications to an SQS queue. Hint: Use the subscribe() method of the
	 * client object. The subscription endpoint is provided to you in the queueArn parameter.
	 * 
	 * @param snsClient The SNS client object.
	 * @param queueArn The ARN for the queue that will be used as the subscription endpoint.
	 * @param topicArn The ARN for the topic to subscribe to.
	 */
	@Override
	public void createSubscription(AmazonSNSClient snsClient, String queueArn, String topicArn) {
		SubscribeRequest request = new SubscribeRequest()
			.withEndpoint(queueArn)
			.withProtocol("sqs")
			.withTopicArn(topicArn);
		
		snsClient.subscribe(request);
	}

	/**
	 * Publish a message to the specified SNS topic. Hint: Use the publish() method of the client object.
	 * 
	 * @param snsClient The SNS client object.
	 * @param topicArn The ARN for the topic to post the message to.
	 * @param subject The subject of the message to publish.
	 * @param message The body of the message to publish.
	 */
	@Override
	public void publishTopicMessage(AmazonSNSClient snsClient, String topicArn, String subject, String message) {
		PublishRequest request = new PublishRequest()
			.withSubject(subject)
			.withMessage(message)
			.withTopicArn(topicArn);
		
		snsClient.publish(request);
	}

	/**
	 * Post a message to the specified queue. Hint: Use the sendMessage() method of the client object.
	 * 
	 * @param sqsClient The SQS Client object.
	 * @param queueUrl The URL for the queue to place the message in.
	 * @param messageText The body of the message to place in the queue.
	 */
	@Override
	public void postToQueue(AmazonSQSClient sqsClient, String queueUrl, String messageText) {
		SendMessageRequest request = new SendMessageRequest(queueUrl, messageText);
		
		sqsClient.sendMessage(request);
	}

	/**
	 * Read up to 10 messages from the specified SQS queue with one request. Hint: Use the receiveMessage() method of
	 * the client object. In the request, set the maximum number of messages to 10.
	 * 
	 * @param sqsClient The SQS Client object.
	 * @param queueUrl The URL of the queue containing the messages.
	 * @return A list of messages from the queue.
	 */
	@Override
	public List<Message> readMessages(AmazonSQSClient sqsClient, String queueUrl) {
		ReceiveMessageRequest request = new ReceiveMessageRequest(queueUrl);
		
		return sqsClient.receiveMessage(request).getMessages();
	}

	/**
	 * Delete the specified message from the specified queue. Hint: Use the deleteMessage() method of the client object.
	 * 
	 * @param sqsClient The SQS Client object.
	 * @param queueUrl The URL of the queue containing the message.
	 * @param receiptHandle The receipt handle of the message to delete.
	 */
	@Override
	public void removeMessage(AmazonSQSClient sqsClient, String queueUrl, String receiptHandle) {
		DeleteMessageRequest request = new DeleteMessageRequest(queueUrl, receiptHandle);
		
		sqsClient.deleteMessage(request);
	}

	/**
	 * Delete all subscriptions to the specified SNS topic. Hint: Call getSubscriptions() on the client object to get
	 * all of the subscriptions and loop through them calling the client object's unsubscribe() method with details of
	 * each subscription.
	 * 
	 * @param snsClient The SNS client object.
	 * @param topicArn The SNS topic to remove the subscriptions from.
	 */
	@Override
	public void deleteSubscriptions(AmazonSNSClient snsClient, String topicArn) {
		ListSubscriptionsByTopicRequest request = new ListSubscriptionsByTopicRequest(topicArn);
		ListSubscriptionsByTopicResult result = snsClient.listSubscriptionsByTopic(request);
		
		for (Subscription s : result.getSubscriptions()) {
			UnsubscribeRequest unsubscribeRequest = new UnsubscribeRequest(s.getSubscriptionArn());
			snsClient.unsubscribe(unsubscribeRequest);
		}
	}

	/**
	 * Delete the specified SNS topic. Hint: Use the deleteTopic() method of the client object.
	 * 
	 * @param snsClient The SNS client object.
	 * @param topicArn The ARN of the topic to delete.
	 */
	@Override
	public void deleteTopic(AmazonSNSClient snsClient, String topicArn) {
		// TODO: Replace this call to the super class with your own method implementation.
		super.deleteTopic(snsClient, topicArn);
	}

	/**
	 * Delete the specified SQS queue. Hint: Use the deleteQueue() method of the client object.
	 * 
	 * @param sqsClient The SQS Client object.
	 * @param queueUrl The URL of the queue to delete.
	 */
	@Override
	public void deleteQueue(AmazonSQSClient sqsClient, String queueUrl) {
		// TODO: Replace this call to the super class with your own method implementation.
		super.deleteQueue(sqsClient, queueUrl);
	}

	// OPTIONAL TASK
	/**
	 * Grant permissions allowing the provided SNS topic to publish messages to your queue. To accomplish this you will
	 * need to create a properly formed policy statement and assign it to the Policy attribute of the queue. You will
	 * need to do some research to get this right.
	 * 
	 * @param sqsClient The SQS Client object.
	 * @param queueArn The ARN defining the queue. This is used as the Resource in the policy statement.
	 * @param queueUrl The URL for the queue. This is used to identify the queue for the purpose of updating its Policy
	 *            attribute.
	 * @param topicArn The ARN for the topic that will publish to the queue. This will be used as a source ARN Condition
	 *            in the policy statement.
	 */
	@Override
	public void grantNotificationPermission(AmazonSQSClient sqsClient, String queueArn, String queueUrl, String topicArn) {
		// TODO: Replace this call to the super class with your own method implementation.
		super.grantNotificationPermission(sqsClient, queueArn, queueUrl, topicArn);
	}
}
