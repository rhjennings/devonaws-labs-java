package awslabs.dev.challenge;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityRequest;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class DevChallenge {
	private static Region usEast1 = Region.getRegion(Regions.US_EAST_1);
	private static String sqsName = "dev-challenge1-sqs-" + UUID.randomUUID();
	private static String bucketName = "dev-challenge1-bucket-" + UUID.randomUUID();
	
	private static String image1 = "http://photojournal.jpl.nasa.gov/jpeg/PIA17563.jpg";
	private static String image2 = "http://photojournal.jpl.nasa.gov/jpeg/PIA13316.jpg";
	private static String image3 = "http://www.noaanews.noaa.gov/stories2014/images/ingridmanuel_tmo_2013258_lrg.jpg";
	private static String image4 = "http://solarsystem.nasa.gov/multimedia/gallery/PIA03149.jpg";
	private static String image5 = "http://apod.nasa.gov/apod/image/0610/antennae_hst_big.jpg";
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		// retrieve credentials
		AWSCredentials credentials = getCredentials();
		
		// create SQS queue
		AmazonSQS sqsClient = new AmazonSQSClient(credentials);
		sqsClient.setRegion(usEast1);
		CreateQueueRequest queueRequest = new CreateQueueRequest(sqsName);
		String sqsUrl = sqsClient.createQueue(queueRequest).getQueueUrl();
		
		// create S3 bucket
		AmazonS3 s3Client = new AmazonS3Client(credentials);
		s3Client.setRegion(usEast1);
		CreateBucketRequest bucketRequest = new CreateBucketRequest(bucketName);
        s3Client.createBucket(bucketRequest);
        
		// send messages to queue
		sendMessagesToQueue(sqsClient, sqsUrl);
		
		// consume message
		ReceiveMessageRequest msgRequest = new ReceiveMessageRequest(sqsUrl);
		List<Message> messages = sqsClient.receiveMessage(msgRequest).getMessages();
		
		for (Message m : messages) {
			ChangeMessageVisibilityRequest changeMessageVisibilityRequest = new ChangeMessageVisibilityRequest()
				.withQueueUrl(sqsUrl)
				.withReceiptHandle(m.getReceiptHandle())
				.withVisibilityTimeout(3600);
			
			// mark message
			sqsClient.changeMessageVisibility(changeMessageVisibilityRequest);
			
			
			String body = m.getBody();
			for (String s : body.split("\n")) {
				int counter = 1;
				// download and resize image
				BufferedImage i = ImageIO.read(new URL(s));
				File file = new File("");
				ImageIO.write(i, "", file);
				
				// save image in S3
				PutObjectRequest objectRequest = new PutObjectRequest(bucketName, "image" + counter, file);
				s3Client.putObject(objectRequest);
				
				counter++;
			}
			
			// delete message from queue
			DeleteMessageRequest messageRequest = new DeleteMessageRequest(sqsUrl, m.getReceiptHandle());
			sqsClient.deleteMessage(messageRequest);
		}
	}

	private static AWSCredentials getCredentials() {
		AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider("ClassroomUser").getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (C:\\Users\\student\\.aws\\credentials), and is in valid format.",
                    e);
        }
        return credentials;
	}
	
	private static void sendMessagesToQueue(AmazonSQS sqsClient, String queueUrl) {
		sqsClient.sendMessage(queueUrl, image1 + "\n" + image2 + "\n" + image3 + "\n" + image4 + "\n" + image5);
	}
}
